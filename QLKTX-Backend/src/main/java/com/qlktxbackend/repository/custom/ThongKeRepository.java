package com.qlktxbackend.repository.custom;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ThongKeRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List thongKeKhachTheoThang(Integer month, Integer year){
        String sqlBuilder = "select lt.ma_sv maSv, sv.lop, sv.ma_so_dinh_danh_S maSoDinhDanhS, lt.ma_so_dinh_danh_K maSoDinhDanhK, " +
                "k.nghe_nghiep ngheNghiep, n.ho_ten hoTen, n.gioi_tinh gioiTinh, n.ngay_sinh ngaySinh, " +
                "n.dia_chi_thuong_chu diaChiThuongChu, count(*) as soLuotTham " +
                "from (select * from luot_tham where MONTH(thoi_gian_den) = :month and YEAR(thoi_gian_den) = :year) lt " +
                "left join sinh_vien sv on sv.ma_sv = lt.ma_sv " +
                "left join khach k on k.ma_so_dinh_danh_K = lt.ma_so_dinh_danh_K " +
                "left join nguoi n on n.ma_so_dinh_danh = lt.ma_so_dinh_danh_K " +
                "group by maSv, maSoDinhDanhK";
        Query query = entityManager.createNativeQuery(sqlBuilder);
        query.setParameter("month", month);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List thongKeTienDienNuocTheoThang(Integer month, Integer year){
        String sqlBuilder = "select lt.ma_sv maSv, sv.lop, sv.ma_so_dinh_danh_S maSoDinhDanhS, lt.ma_so_dinh_danh_K maSoDinhDanhK, " +
                "k.nghe_nghiep ngheNghiep, n.ho_ten hoTen, n.gioi_tinh gioiTinh, n.ngay_sinh ngaySinh, " +
                "n.dia_chi_thuong_chu diaChiThuongChu, count(*) as soLuotTham " +
                "from (select * from luot_tham where MONTH(thoi_gian_den) = :month and YEAR(ngay_ket_thuc) = :year) lt " +
                "left join sinh_vien sv on sv.ma_sv = lt.ma_sv " +
                "left join khach k on k.ma_so_dinh_danh_K = lt.ma_so_dinh_danh_K " +
                "left join nguoi n on n.ma_so_dinh_danh = lt.ma_so_dinh_danh_K " +
                "group by maSv, maSoDinhDanhK";
        Query query = entityManager.createNativeQuery(sqlBuilder);
        query.setParameter("month", month);
        query.setParameter("year", year);
        return query.getResultList();
    }
}
