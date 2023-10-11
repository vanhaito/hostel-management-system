package com.qlktxbackend.service;

import com.qlktxbackend.repository.NhanVienQlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienQlService {

    @Autowired
    private NhanVienQlRepository nhanVienQlRepository;


}
