package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.KyTucXaRequestDTO;
import com.qlktxbackend.dto.request.KyTucXaUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.KyTucXaResponseDTO;
import com.qlktxbackend.service.impl.KyTucXaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/ky-tuc-xa")
public class KyTucXaController {

    @Autowired
    private KyTucXaServiceImpl kyTucXaServiceImpl;

    @PostMapping
    public KyTucXaResponseDTO save(@Valid @RequestBody KyTucXaRequestDTO requestDTO) {
        return kyTucXaServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") String id) {
        return kyTucXaServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody KyTucXaUpdateRequestDTO requestDTO) {
        return kyTucXaServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public KyTucXaResponseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return kyTucXaServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<KyTucXaResponseDTO> getAll() {
        return kyTucXaServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<KyTucXaResponseDTO> query(@Valid KyTucXaQueryRequestDTO requestDTO) {
//        return kyTucXaService.query(requestDTO);
//    }
}
