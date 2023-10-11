package com.qlktxbackend.repository;

import com.qlktxbackend.entities.HoaDonDienNuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HoaDonDienNuocRepository extends JpaRepository<HoaDonDienNuoc, String>, JpaSpecificationExecutor<HoaDonDienNuoc> {

}