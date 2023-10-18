package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.LoaiPhongRequestDTO;
import com.qlktxbackend.dto.request.LoaiPhongUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.LoaiPhongResponseDTO;
import com.qlktxbackend.service.impl.LoaiPhongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/loai-phong")
public class LoaiPhongController {

    @Autowired
    private LoaiPhongServiceImpl loaiPhongServiceImpl;

    @PostMapping
    public LoaiPhongResponseDTO save(@Valid @RequestBody LoaiPhongRequestDTO requestDTO) {
        return loaiPhongServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") String id) {
        return loaiPhongServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody LoaiPhongUpdateRequestDTO requestDTO) {
        return loaiPhongServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public LoaiPhongResponseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return loaiPhongServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<LoaiPhongResponseDTO> getAll() {
        return loaiPhongServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<LoaiPhongResponseDTO> query(@Valid LoaiPhongQueryRequestDTO requestDTO) {
//        return loaiPhongService.query(requestDTO);
//    }
}
