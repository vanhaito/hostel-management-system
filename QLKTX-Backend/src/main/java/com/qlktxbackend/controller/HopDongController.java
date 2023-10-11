package com.qlktxbackend.controller;

import com.qlktxbackend.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/hopDong")
public class HopDongController {

    @Autowired
    private HopDongService hopDongService;

}
