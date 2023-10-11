package com.qlktxbackend.repository;

import com.qlktxbackend.entities.LuotTham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LuotThamRepository extends JpaRepository<LuotTham, Integer>, JpaSpecificationExecutor<LuotTham> {

}