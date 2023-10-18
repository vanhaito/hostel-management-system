package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.SinhVienRequestDTO;
import com.qlktxbackend.dto.request.SinhVienUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.SinhVienResponseDTO;
import com.qlktxbackend.service.impl.SinhVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/sinh-vien")
public class SinhVienController {

    @Autowired
    private SinhVienServiceImpl sinhVienServiceImpl;

    @PostMapping
    public SinhVienResponseDTO save(@Valid @RequestBody SinhVienRequestDTO requestDTO) {
        return sinhVienServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") String id) {
        return sinhVienServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody SinhVienUpdateRequestDTO requestDTO) {
        return sinhVienServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public SinhVienResponseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return sinhVienServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<SinhVienResponseDTO> getAll() {
        return sinhVienServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<SinhVienResponseDTO> query(@Valid SinhVienQueryRequestDTO requestDTO) {
//        return sinhVienService.query(requestDTO);
//    }
}
