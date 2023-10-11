package com.qlktxbackend.service;

import com.qlktxbackend.repository.VeXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeXeService {

    @Autowired
    private VeXeRepository veXeRepository;

}
