package com.qlktxbackend.service;

import com.qlktxbackend.repository.LuotThamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LuotThamService {

    @Autowired
    private LuotThamRepository luotThamRepository;

}
