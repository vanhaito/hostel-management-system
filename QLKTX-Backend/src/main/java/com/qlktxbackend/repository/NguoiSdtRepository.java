package com.qlktxbackend.repository;

import com.qlktxbackend.entities.NguoiSdt;
import com.qlktxbackend.entities.key.NguoiSdtKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NguoiSdtRepository extends JpaRepository<NguoiSdt, NguoiSdtKey>, JpaSpecificationExecutor<NguoiSdt> {

}