package com.qlktxbackend.repository;

import com.qlktxbackend.entities.HopDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HopDongRepository extends JpaRepository<HopDong, String>, JpaSpecificationExecutor<HopDong> {

}