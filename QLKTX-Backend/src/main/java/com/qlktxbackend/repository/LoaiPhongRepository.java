package com.qlktxbackend.repository;

import com.qlktxbackend.entities.LoaiPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoaiPhongRepository extends JpaRepository<LoaiPhong, String>, JpaSpecificationExecutor<LoaiPhong> {

}