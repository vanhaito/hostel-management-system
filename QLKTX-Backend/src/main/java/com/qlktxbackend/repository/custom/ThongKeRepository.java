package com.qlktxbackend.repository.custom;

import com.qlktxbackend.repository.custom.entity.DienNuocPhongTheoThang;
import com.qlktxbackend.repository.custom.entity.KhachTheoThang;
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
                .addScalar("tienDien", StandardBasicTypes.DOUBLE)
                .addScalar("tienNuoc", StandardBasicTypes.DOUBLE)
                .setResultTransformer(Transformers.aliasToBean(DienNuocPhongTheoThang.class));
        query.setParameter("month", month);
        query.setParameter("year", year);
        return query.getResultList();
    }
}
