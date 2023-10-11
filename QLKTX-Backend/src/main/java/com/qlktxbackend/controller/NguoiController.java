package com.qlktxbackend.controller;

import com.qlktxbackend.service.NguoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/nguoi")
public class NguoiController {

    @Autowired
    private NguoiService nguoiService;

}
