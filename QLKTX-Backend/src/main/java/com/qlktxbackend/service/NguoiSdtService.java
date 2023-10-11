package com.qlktxbackend.service;

import com.qlktxbackend.repository.NguoiSdtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NguoiSdtService {

    @Autowired
    private NguoiSdtRepository nguoiSdtRepository;

}
