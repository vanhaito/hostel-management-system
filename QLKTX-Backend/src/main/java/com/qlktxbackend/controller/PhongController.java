package com.qlktxbackend.controller;

import com.qlktxbackend.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/phong")
public class PhongController {

    @Autowired
    private PhongService phongService;

}
