package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.HopDongRequestDTO;
import com.qlktxbackend.dto.request.HopDongUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.HopDongResponseDTO;
import com.qlktxbackend.service.impl.HopDongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@Validated
@RestController
@RequestMapping("/hop-dong")
public class HopDongController {

    @Autowired
    private HopDongServiceImpl hopDongServiceImpl;

    @PostMapping
    public HopDongResponseDTO save(@Valid @RequestBody HopDongRequestDTO requestDTO) {
        return hopDongServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") String id) {
        return hopDongServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody HopDongUpdateRequestDTO requestDTO) {
        return hopDongServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public HopDongResponseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return hopDongServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<HopDongResponseDTO> getAll() {
        return hopDongServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<HopDongResponseDTO> query(@Valid HopDongQueryRequestDTO requestDTO) {
//        return hopDongService.query(requestDTO);
//    }
}
