package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.PhongRequestDTO;
import com.qlktxbackend.dto.request.PhongUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.PhongResponseDTO;
import com.qlktxbackend.entities.Phong;
import com.qlktxbackend.entities.key.PhongKey;
import com.qlktxbackend.service.impl.PhongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/phong")
public class PhongController {

    @Autowired
    private PhongServiceImpl phongService;

    @PostMapping
    public PhongResponseDTO save(@Valid @RequestBody PhongRequestDTO requestDTO) {
        return phongService.save(requestDTO);
    }

    @DeleteMapping("/{tenKyTucXa}/{tenPhong}")
    public boolean delete(@Valid @NotNull @PathVariable("tenKyTucXa") String tenKyTucXa,
                          @Valid @NotNull @PathVariable("tenPhong") String tenPhong) {
        PhongKey phongKey = PhongKey.builder().tenKyTucXa(tenKyTucXa).tenPhong(tenPhong).build();
        return phongService.delete(phongKey);
    }

    @PutMapping("/{tenKyTucXa}/{tenPhong}")
    public boolean update(@Valid @NotNull @PathVariable("tenKyTucXa") String tenKyTucXa,
                          @Valid @NotNull @PathVariable("tenPhong") String tenPhong,
                       @Valid @RequestBody PhongUpdateRequestDTO requestDTO) {
        PhongKey phongKey = PhongKey.builder().tenKyTucXa(tenKyTucXa).tenPhong(tenPhong).build();
        return phongService.update(phongKey, requestDTO);
    }

    @GetMapping("/{tenKyTucXa}/{tenPhong}")
    public PhongResponseDTO getById(@Valid @NotNull @PathVariable("tenKyTucXa") String tenKyTucXa,
                                    @Valid @NotNull @PathVariable("tenPhong") String tenPhong) {
        PhongKey phongKey = PhongKey.builder().tenKyTucXa(tenKyTucXa).tenPhong(tenPhong).build();
        return phongService.getById(phongKey);
    }

    @GetMapping("/get-all")
    public List<PhongResponseDTO> getAll() {
        return phongService.getAll();
    }

//    @GetMapping
//    public Page<PhongResponseDTO> query(@Valid PhongQueryRequestDTO requestDTO) {
//        return phongService.query(requestDTO);
//    }
}
