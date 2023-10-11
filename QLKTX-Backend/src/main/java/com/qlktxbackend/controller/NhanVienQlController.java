package com.qlktxbackend.controller;

import com.qlktxbackend.service.NhanVienQlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/nhanVienQl")
public class NhanVienQlController {

    @Autowired
    private NhanVienQlService nhanVienQlService;

}
