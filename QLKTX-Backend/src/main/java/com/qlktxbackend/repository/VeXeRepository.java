package com.qlktxbackend.repository;

import com.qlktxbackend.entities.VeXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VeXeRepository extends JpaRepository<VeXe, String>, JpaSpecificationExecutor<VeXe> {

}