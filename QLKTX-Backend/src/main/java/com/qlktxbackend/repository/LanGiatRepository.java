package com.qlktxbackend.repository;

import com.qlktxbackend.entities.LanGiat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LanGiatRepository extends JpaRepository<LanGiat, Integer>, JpaSpecificationExecutor<LanGiat> {

}