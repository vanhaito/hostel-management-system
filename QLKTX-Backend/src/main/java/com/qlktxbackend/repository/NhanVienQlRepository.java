package com.qlktxbackend.repository;

import com.qlktxbackend.entities.NhanVienQl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NhanVienQlRepository extends JpaRepository<NhanVienQl, String>, JpaSpecificationExecutor<NhanVienQl> {

}