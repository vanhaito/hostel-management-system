package com.qlktxbackend.controller;

import com.qlktxbackend.service.LuotThamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/luotTham")
public class LuotThamController {

    @Autowired
    private LuotThamService luotThamService;

}
