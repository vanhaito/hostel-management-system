package com.qlktxbackend.controller;

import com.qlktxbackend.service.impl.ThongKeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/thong-ke")
public class ThongKeController {

    @Autowired
    private ThongKeServiceImpl thongKeService;


    @GetMapping("/khach-theo-thang/{month}/{year}")
    public List getThongKeKhachTheoThang(@Valid @NotNull @PathVariable("month") Integer month,@Valid @NotNull @PathVariable Integer year) {
        return thongKeService.getThongKeKhachTheoThang(month, year);
    }

    @GetMapping("/dien-nuoc-theo-thang/{month}/{year}")
    public List getThongKeTienDienNuocTheoThang(@Valid @NotNull @PathVariable("month") Integer month,@Valid @NotNull @PathVariable Integer year) {
        return thongKeService.getThongKeTienDienNuocTheoThang(month, year);
    }
}
