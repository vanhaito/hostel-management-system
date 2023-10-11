package com.qlktxbackend.service;

import com.qlktxbackend.repository.HopDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HopDongService {

    @Autowired
    private HopDongRepository hopDongRepository;

}
