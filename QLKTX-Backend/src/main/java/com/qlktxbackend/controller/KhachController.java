package com.qlktxbackend.controller;

import com.qlktxbackend.service.KhachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/khach")
public class KhachController {

    @Autowired
    private KhachService khachService;

//    @PostMapping
//    public String save(@Valid @RequestBody KhachVO vO) {
//        return khachService.save(vO).toString();
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@Valid @NotNull @PathVariable("id") String id) {
//        khachService.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@Valid @NotNull @PathVariable("id") String id,
//                       @Valid @RequestBody KhachUpdateVO vO) {
//        khachService.update(id, vO);
//    }
//
//    @GetMapping("/{id}")
//    public KhachDTO getById(@Valid @NotNull @PathVariable("id") String id) {
//        return khachService.getById(id);
//    }
//
//    @GetMapping
//    public Page<KhachDTO> query(@Valid KhachQueryVO vO) {
//        return khachService.query(vO);
//    }
}
