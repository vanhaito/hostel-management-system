package com.qlktxbackend.service;

import com.qlktxbackend.repository.NguoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NguoiService {

    @Autowired
    private NguoiRepository nguoiRepository;

}
