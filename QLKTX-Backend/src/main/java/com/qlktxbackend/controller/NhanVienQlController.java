package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.NhanVienQlRequestDTO;
import com.qlktxbackend.dto.request.NhanVienQlUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.NhanVienQlResponseDTO;
import com.qlktxbackend.service.impl.NhanVienQlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/nhan-vien-ql")
public class NhanVienQlController {

    @Autowired
    private NhanVienQlServiceImpl nhanVienQlServiceImpl;

    @PostMapping
    public NhanVienQlResponseDTO save(@Valid @RequestBody NhanVienQlRequestDTO requestDTO) {
        return nhanVienQlServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") String id) {
        return nhanVienQlServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody NhanVienQlUpdateRequestDTO requestDTO) {
        return nhanVienQlServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public NhanVienQlResponseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return nhanVienQlServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<NhanVienQlResponseDTO> getAll() {
        return nhanVienQlServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<NhanVienQlResponseDTO> query(@Valid NhanVienQlQueryRequestDTO requestDTO) {
//        return nhanVienQlService.query(requestDTO);
//    }
}
