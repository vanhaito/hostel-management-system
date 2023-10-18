package com.qlktxbackend.repository;

import com.qlktxbackend.entities.Phong;
import com.qlktxbackend.entities.key.PhongKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhongRepository extends JpaRepository<Phong, PhongKey>, JpaSpecificationExecutor<Phong> {

}