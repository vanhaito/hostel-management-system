package com.qlktxbackend.controller;

import com.qlktxbackend.service.LoaiPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/loaiPhong")
public class LoaiPhongController {

    @Autowired
    private LoaiPhongService loaiPhongService;

}
