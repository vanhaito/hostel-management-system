package com.qlktxbackend.controller;

import com.qlktxbackend.service.LanGuiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/lanGuiXe")
public class LanGuiXeController {

    @Autowired
    private LanGuiXeService lanGuiXeService;

}
