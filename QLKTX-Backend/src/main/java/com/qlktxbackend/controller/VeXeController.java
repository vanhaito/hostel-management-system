package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.VeXeRequestDTO;
import com.qlktxbackend.dto.request.VeXeUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.VeXeResponseDTO;
import com.qlktxbackend.helpers.ResponseFactory;
import com.qlktxbackend.service.impl.VeXeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/ve-xe")
public class VeXeController {

    @Autowired
    private VeXeServiceImpl veXeServiceImpl;

//    @Autowired
//    private ResponseFactory responseFactory;

    @PostMapping
    public VeXeResponseDTO save(@Valid @RequestBody VeXeRequestDTO requestDTO) {
        return veXeServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") String id) {
        return veXeServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody VeXeUpdateRequestDTO requestDTO) {
        return veXeServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public VeXeResponseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return veXeServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<VeXeResponseDTO> getAll() {
        return veXeServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<VeXeResponseDTO> query(@Valid VeXeQueryRequestDTO requestDTO) {
//        return veXeService.query(requestDTO);
//    }
}
