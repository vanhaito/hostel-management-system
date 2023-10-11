package com.qlktxbackend.service;

import com.qlktxbackend.repository.HoaDonDienNuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonDienNuocService {

    @Autowired
    private HoaDonDienNuocRepository hoaDonDienNuocRepository;

}
