package com.qlktxbackend.controller;


import com.qlktxbackend.service.HoaDonDienNuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/hoaDonDienNuoc")
public class HoaDonDienNuocController {

    @Autowired
    private HoaDonDienNuocService hoaDonDienNuocService;


}
