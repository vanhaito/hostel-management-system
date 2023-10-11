package com.qlktxbackend.controller;

import com.qlktxbackend.service.LanGiatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/lanGiat")
public class LanGiatController {

    @Autowired
    private LanGiatService lanGiatService;

}
