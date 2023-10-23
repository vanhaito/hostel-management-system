package com.qlktxbackend.controller;


import com.qlktxbackend.dto.request.HoaDonDienNuocRequestDTO;
import com.qlktxbackend.dto.request.HoaDonDienNuocUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.service.impl.HoaDonDienNuocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@Validated
@RestController
@RequestMapping("/hoa-don-dien-nuoc")
public class HoaDonDienNuocController {

    @Autowired
    private HoaDonDienNuocServiceImpl hoaDonDienNuocServiceImpl;


    @PostMapping
    public HoaDonDienNuocResponseDTO save(@Valid @RequestBody HoaDonDienNuocRequestDTO requestDTO) {
        return hoaDonDienNuocServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") String id) {
        return hoaDonDienNuocServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody HoaDonDienNuocUpdateRequestDTO requestDTO) {
        return hoaDonDienNuocServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public HoaDonDienNuocResponseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return hoaDonDienNuocServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<HoaDonDienNuocResponseDTO> getAll() {
        return hoaDonDienNuocServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<HoaDonDienNuocResponseDTO> query(@Valid HoaDonDienNuocQueryRequestDTO requestDTO) {
//        return hoaDonDienNuocService.query(requestDTO);
//    }
}
