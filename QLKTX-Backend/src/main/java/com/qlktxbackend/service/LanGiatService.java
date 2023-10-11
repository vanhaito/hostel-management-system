package com.qlktxbackend.service;

import com.qlktxbackend.repository.LanGiatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanGiatService {

    @Autowired
    private LanGiatRepository lanGiatRepository;

}
