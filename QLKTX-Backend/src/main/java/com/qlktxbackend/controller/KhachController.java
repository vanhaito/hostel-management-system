package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.KhachRequestDTO;
import com.qlktxbackend.dto.request.KhachUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.KhachResponseDTO;
import com.qlktxbackend.service.impl.KhachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/khach")
public class KhachController {

    @Autowired
    private KhachServiceImpl khachServiceImpl;

    @PostMapping
    public KhachResponseDTO save(@Valid @RequestBody KhachRequestDTO requestDTO) {
        return khachServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") String id) {
        return khachServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody KhachUpdateRequestDTO requestDTO) {
        return khachServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public KhachResponseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return khachServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<KhachResponseDTO> getAll() {
        return khachServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<KhachResponseDTO> query(@Valid KhachQueryRequestDTO requestDTO) {
//        return khachService.query(requestDTO);
//    }
}
