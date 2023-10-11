package com.qlktxbackend.repository;

import com.qlktxbackend.entities.Phong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhongRepository extends JpaRepository<Phong, String>, JpaSpecificationExecutor<Phong> {

}