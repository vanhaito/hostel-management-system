package com.qlktxbackend.service;

import com.qlktxbackend.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

}
