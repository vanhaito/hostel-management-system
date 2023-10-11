package com.qlktxbackend.repository;

import com.qlktxbackend.entities.KyTucXa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface KyTucXaRepository extends JpaRepository<KyTucXa, String>, JpaSpecificationExecutor<KyTucXa> {

}