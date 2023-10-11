package com.qlktxbackend.service;

import com.qlktxbackend.repository.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhongService {

    @Autowired
    private PhongRepository phongRepository;

}
