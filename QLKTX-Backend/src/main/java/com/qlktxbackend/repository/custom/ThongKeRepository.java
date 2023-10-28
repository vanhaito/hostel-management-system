package com.qlktxbackend.repository.custom;

import com.qlktxbackend.repository.custom.entity.DienNuocPhongTheoThang;
import com.qlktxbackend.repository.custom.entity.KhachTheoThang;
import com.qlktxbackend.repository.custom.entity.TienDichVuSVTheoThang;
import com.qlktxbackend.repository.custom.entity.TongTienSVTheoThang;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class ThongKeRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<KhachTheoThang> thongKeKhachTheoThang(Integer month, Integer year){
        String sqlBuilder = "select lt.ma_sv maSv, sv.lop, sv.ma_so_dinh_danh_S maSoDinhDanhS, lt.ma_so_dinh_danh_K maSoDinhDanhK, " +
                "k.nghe_nghiep ngheNghiep, n.ho_ten hoTen, n.gioi_tinh gioiTinh, n.ngay_sinh ngaySinh, " +
                "n.dia_chi_thuong_chu diaChiThuongChu, count(*) as soLuotTham " +
                "from (select * from luot_tham where MONTH(thoi_gian_den) = :month and YEAR(thoi_gian_den) = :year) lt " +
                "left join sinh_vien sv on sv.ma_sv = lt.ma_sv " +
                "left join khach k on k.ma_so_dinh_danh_K = lt.ma_so_dinh_danh_K " +
                "left join nguoi n on n.ma_so_dinh_danh = lt.ma_so_dinh_danh_K " +
                "group by maSv, maSoDinhDanhK";
        Query query = entityManager.createNativeQuery(sqlBuilder).unwrap(NativeQuery.class)
                .addScalar("maSv", StandardBasicTypes.STRING)
                .addScalar("lop", StandardBasicTypes.STRING)
                .addScalar("maSoDinhDanhS", StandardBasicTypes.STRING)
                .addScalar("maSoDinhDanhK", StandardBasicTypes.STRING)
                .addScalar("ngheNghiep", StandardBasicTypes.STRING)
                .addScalar("hoTen", StandardBasicTypes.STRING)
                .addScalar("gioiTinh", StandardBasicTypes.STRING)
                .addScalar("ngaySinh", StandardBasicTypes.DATE)
                .addScalar("diaChiThuongChu", StandardBasicTypes.STRING)
                .addScalar("soLuotTham", StandardBasicTypes.INTEGER)
                .setResultTransformer(Transformers.aliasToBean(KhachTheoThang.class));
        query.setParameter("month", month);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<DienNuocPhongTheoThang> thongKeTienDienNuocTheoThang(Integer month, Integer year){
        String sqlBuilder = "select p.ten_ky_tuc_xa tenKyTucXa, p.ten_phong tenPhong, p.so_SV_hien_co soSvHienCo " +
                ", p.tang , p.ma_loai_phong maLoaiPhong " +
                ", hddn.ngay_bat_dau ngayBatDau, hddn.ngay_ket_thuc ngayKetThuc, hddn.ngay_lap_hoa_don ngayLapHD " +
                ", IFNULL((hddn.chi_so_dien_cuoi - hddn.chi_so_dien_dau) * hddn.don_gia_dien, 0) as tienDien " +
                ", IFNULL((hddn.chi_so_nuoc_cuoi - hddn.chi_so_nuoc_dau) * hddn.don_gia_nuoc, 0) as tienNuoc " +
                "from phong p left join(select * from hoa_don_dien_nuoc where MONTH(ngay_ket_thuc) = :month and YEAR(ngay_ket_thuc) = :year) hddn " +
                "on p.ten_ky_tuc_xa = hddn.ten_ktx and p.ten_phong = hddn.ten_phong ";
        Query query = entityManager.createNativeQuery(sqlBuilder).unwrap(NativeQuery.class)
                .addScalar("tenKyTucXa", StandardBasicTypes.STRING)
                .addScalar("tenPhong", StandardBasicTypes.STRING)
                .addScalar("soSvHienCo", StandardBasicTypes.INTEGER)
                .addScalar("tang", StandardBasicTypes.INTEGER)
                .addScalar("maLoaiPhong", StandardBasicTypes.STRING)
                .addScalar("ngayBatDau", StandardBasicTypes.DATE)
                .addScalar("ngayKetThuc", StandardBasicTypes.DATE)
                .addScalar("ngayLapHD", StandardBasicTypes.DATE)
                .addScalar("tienDien", StandardBasicTypes.DOUBLE)
                .addScalar("tienNuoc", StandardBasicTypes.DOUBLE)
                .setResultTransformer(Transformers.aliasToBean(DienNuocPhongTheoThang.class));
        query.setParameter("month", month);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<TongTienSVTheoThang> thongKeTongTienSVTheoThang(Integer month, Integer year){
        String sqlBuilder = "SELECT sv.ma_sv AS maSinhVien, ng.ho_ten AS hoTen, sv.lop as lop, p.ten_phong tenPhong, " +
                "p.ten_ky_tuc_xa tenKtx, SUM(IFNULL(lp.gia, 0) + CASE WHEN IFNULL(gx.lan_gui, 0) > 2 THEN (IFNULL(gx.lan_gui, 0) - 2) * 3000 ELSE 0 " +
                "END + IFNULL(vx.gia_tien, 0) + IFNULL(lg.tien_giat, 0)) AS tongTien " +
                "FROM sinh_vien sv INNER JOIN nguoi ng ON sv.ma_so_dinh_danh_S = ng.ma_so_dinh_danh " +
                "INNER JOIN hop_dong hd ON sv.ma_sv = hd.ma_SV AND MONTH(ngay_ket_thuc) >= :month and YEAR(ngay_ket_thuc) >= :year " +
                "INNER JOIN phong p ON hd.ten_phong = p.ten_phong AND hd.ten_ktx = p.ten_ky_tuc_xa " +
                "INNER JOIN loai_phong lp ON p.ma_loai_phong = lp.ma_loai_phong " +
                "LEFT JOIN (SELECT ma_sv, COUNT(*) AS lan_gui FROM lan_gui_xe " +
                "WHERE MONTH(thoi_gian_gui) = :month and YEAR(thoi_gian_gui) = :year GROUP BY ma_sv) gx ON sv.ma_sv = gx.ma_SV " +
                "LEFT JOIN (SELECT ma_sv, COUNT(*) * 100000 AS gia_tien FROM ve_xe GROUP BY ma_sv) vx ON sv.ma_sv = vx.ma_sv " +
                "LEFT JOIN (SELECT ma_SV, SUM(don_gia * khoi_luong) AS tien_giat FROM lan_giat " +
                "WHERE MONTH(ngay_giat) = :month and YEAR(ngay_giat) = :year GROUP BY ma_SV) lg ON sv.ma_sv = lg.ma_SV " +
                "GROUP BY sv.ma_sv ";
        Query query = entityManager.createNativeQuery(sqlBuilder).unwrap(NativeQuery.class)
                .addScalar("maSinhVien", StandardBasicTypes.STRING)
                .addScalar("hoTen", StandardBasicTypes.STRING)
                .addScalar("lop", StandardBasicTypes.STRING)
                .addScalar("tenPhong", StandardBasicTypes.STRING)
                .addScalar("tenKtx", StandardBasicTypes.STRING)
                .addScalar("tongTien", StandardBasicTypes.DOUBLE)
                .setResultTransformer(Transformers.aliasToBean(TongTienSVTheoThang.class));
        query.setParameter("month", month);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<TienDichVuSVTheoThang> thongKeTienDichVuSVTheoThang(Integer month, Integer year){
        String sqlBuilder = "SELECT sv.ma_sv AS maSinhVien, ng.ho_ten AS hoTen, sv.lop as lop, p.ten_phong tenPhong, " +
                "p.ten_ky_tuc_xa tenKtx, SUM(IFNULL(lp.gia, 0)) AS tienPhong, " +
                "SUM( CASE WHEN IFNULL(gx.lan_gui, 0) > 2 THEN (IFNULL(gx.lan_gui, 0) - 2) * 3000 ELSE 0 END ) AS tienGuiXe, " +
                "SUM(IFNULL(vx.gia_tien, 0)) AS tienVeXe, SUM(IFNULL(lg.tien_giat, 0)) AS tienGiat " +
                "FROM sinh_vien sv INNER JOIN nguoi ng ON sv.ma_so_dinh_danh_S = ng.ma_so_dinh_danh " +
                "INNER JOIN hop_dong hd ON sv.ma_sv = hd.ma_SV AND MONTH(ngay_ket_thuc) >= :month and YEAR(ngay_ket_thuc) >= :year " +
                "INNER JOIN phong p ON hd.ten_phong = p.ten_phong AND hd.ten_ktx = p.ten_ky_tuc_xa " +
                "INNER JOIN loai_phong lp ON p.ma_loai_phong = lp.ma_loai_phong " +
                "LEFT JOIN (SELECT ma_sv, COUNT(*) AS lan_gui FROM lan_gui_xe WHERE MONTH(thoi_gian_gui) = :month and YEAR(thoi_gian_gui) = :year " +
                "GROUP BY ma_sv) gx ON sv.ma_sv = gx.ma_SV " +
                "LEFT JOIN (SELECT ma_sv, COUNT(*) * 100000 AS gia_tien FROM ve_xe GROUP BY ma_sv) vx ON sv.ma_sv = vx.ma_sv " +
                "LEFT JOIN (SELECT ma_SV, SUM(don_gia * khoi_luong) AS tien_giat FROM lan_giat " +
                "WHERE MONTH(ngay_giat) = :month and YEAR(ngay_giat) = :year GROUP BY ma_SV) lg ON sv.ma_sv = lg.ma_SV " +
                "GROUP BY sv.ma_sv ";
        Query query = entityManager.createNativeQuery(sqlBuilder).unwrap(NativeQuery.class)
                .addScalar("maSinhVien", StandardBasicTypes.STRING)
                .addScalar("hoTen", StandardBasicTypes.STRING)
                .addScalar("lop", StandardBasicTypes.STRING)
                .addScalar("tenPhong", StandardBasicTypes.STRING)
                .addScalar("tenKtx", StandardBasicTypes.STRING)
                .addScalar("tienPhong", StandardBasicTypes.DOUBLE)
                .addScalar("tienVeXe", StandardBasicTypes.DOUBLE)
                .addScalar("tienGiat", StandardBasicTypes.DOUBLE)
                .setResultTransformer(Transformers.aliasToBean(TienDichVuSVTheoThang.class));
        query.setParameter("month", month);
        query.setParameter("year", year);
        return query.getResultList();
    }
}
