package com.qlktxbackend.service;

import com.qlktxbackend.repository.LoaiPhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoaiPhongService {

    @Autowired
    private LoaiPhongRepository loaiPhongRepository;

}
