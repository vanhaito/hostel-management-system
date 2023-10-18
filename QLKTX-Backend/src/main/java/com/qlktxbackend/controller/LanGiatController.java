package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.LanGiatRequestDTO;
import com.qlktxbackend.dto.request.LanGiatUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.LanGiatResponseDTO;
import com.qlktxbackend.service.impl.LanGiatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/lan-giat")
public class LanGiatController {

    @Autowired
    private LanGiatServiceImpl lanGiatServiceImpl;

    @PostMapping
    public LanGiatResponseDTO save(@Valid @RequestBody LanGiatRequestDTO requestDTO) {
        return lanGiatServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") Integer id) {
        return lanGiatServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody LanGiatUpdateRequestDTO requestDTO) {
        return lanGiatServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public LanGiatResponseDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return lanGiatServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<LanGiatResponseDTO> getAll() {
        return lanGiatServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<LanGiatResponseDTO> query(@Valid LanGiatQueryRequestDTO requestDTO) {
//        return lanGiatService.query(requestDTO);
//    }
}
