package com.qlktxbackend.repository;

import com.qlktxbackend.entities.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SinhVienRepository extends JpaRepository<SinhVien, String>, JpaSpecificationExecutor<SinhVien> {

    @Query(value = "select s from SinhVien s inner join HopDong h on s.maSv = h.maSv where h.ngayKetThuc >= current_date ")
    List<SinhVien> findAllSinhVienKyHopDong();


    @Query(value = "select s from SinhVien s left join HopDong h on s.maSv = h.maSv where h.maHopDong is null and h.ngayKetThuc < current_date ")
    List<SinhVien> findAllSinhVienChuaKyHopDong();
}