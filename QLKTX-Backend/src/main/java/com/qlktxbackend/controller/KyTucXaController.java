package com.qlktxbackend.controller;

import com.qlktxbackend.service.KyTucXaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/kyTucXa")
public class KyTucXaController {

    @Autowired
    private KyTucXaService kyTucXaService;

}
