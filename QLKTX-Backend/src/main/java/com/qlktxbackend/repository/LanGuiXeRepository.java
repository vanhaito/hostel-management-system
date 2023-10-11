package com.qlktxbackend.repository;

import com.qlktxbackend.entities.LanGuiXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LanGuiXeRepository extends JpaRepository<LanGuiXe, Integer>, JpaSpecificationExecutor<LanGuiXe> {

}