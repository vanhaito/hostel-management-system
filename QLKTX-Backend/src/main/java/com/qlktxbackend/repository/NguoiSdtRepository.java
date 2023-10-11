package com.qlktxbackend.repository;

import com.qlktxbackend.entities.NguoiSdt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NguoiSdtRepository extends JpaRepository<NguoiSdt, String>, JpaSpecificationExecutor<NguoiSdt> {

}