package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.LuotThamRequestDTO;
import com.qlktxbackend.dto.request.LuotThamUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.LuotThamResponseDTO;
import com.qlktxbackend.service.impl.LuotThamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/luot-tham")
public class LuotThamController {

    @Autowired
    private LuotThamServiceImpl luotThamServiceImpl;

    @PostMapping
    public LuotThamResponseDTO save(@Valid @RequestBody LuotThamRequestDTO requestDTO) {
        return luotThamServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") Integer id) {
        return luotThamServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody LuotThamUpdateRequestDTO requestDTO) {
        return luotThamServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public LuotThamResponseDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return luotThamServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<LuotThamResponseDTO> getAll() {
        return luotThamServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<LuotThamResponseDTO> query(@Valid LuotThamQueryRequestDTO requestDTO) {
//        return luotThamService.query(requestDTO);
//    }
}
