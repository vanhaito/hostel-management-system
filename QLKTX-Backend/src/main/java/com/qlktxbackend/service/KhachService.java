package com.qlktxbackend.service;

import com.qlktxbackend.repository.KhachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachService {

    @Autowired
    private KhachRepository khachRepository;

}
