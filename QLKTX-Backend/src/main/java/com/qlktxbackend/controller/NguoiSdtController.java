package com.qlktxbackend.controller;

import com.qlktxbackend.service.NguoiSdtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/nguoiSdt")
public class NguoiSdtController {

    @Autowired
    private NguoiSdtService nguoiSdtService;

}
