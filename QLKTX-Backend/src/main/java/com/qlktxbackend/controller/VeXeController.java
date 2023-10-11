package com.qlktxbackend.controller;

import com.qlktxbackend.service.VeXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/veXe")
public class VeXeController {

    @Autowired
    private VeXeService veXeService;

}
