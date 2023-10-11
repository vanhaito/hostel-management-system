package com.qlktxbackend.service;

import com.qlktxbackend.repository.KyTucXaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KyTucXaService {

    @Autowired
    private KyTucXaRepository kyTucXaRepository;

}
