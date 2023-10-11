package com.qlktxbackend.repository;

import com.qlktxbackend.entities.Nguoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NguoiRepository extends JpaRepository<Nguoi, String>, JpaSpecificationExecutor<Nguoi> {

}