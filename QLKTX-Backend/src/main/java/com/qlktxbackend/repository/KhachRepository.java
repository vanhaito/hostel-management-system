package com.qlktxbackend.repository;

import com.qlktxbackend.entities.Khach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface KhachRepository extends JpaRepository<Khach, String>, JpaSpecificationExecutor<Khach> {

}