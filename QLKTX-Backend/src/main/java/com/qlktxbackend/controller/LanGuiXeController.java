package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.LanGuiXeRequestDTO;
import com.qlktxbackend.dto.request.LanGuiXeUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.LanGuiXeResponseDTO;
import com.qlktxbackend.service.impl.LanGuiXeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/lan-gui-xe")
public class LanGuiXeController {

    @Autowired
    private LanGuiXeServiceImpl lanGuiXeServiceImpl;

    @PostMapping
    public LanGuiXeResponseDTO save(@Valid @RequestBody LanGuiXeRequestDTO requestDTO) {
        return lanGuiXeServiceImpl.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") Integer id) {
        return lanGuiXeServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody LanGuiXeUpdateRequestDTO requestDTO) {
        return lanGuiXeServiceImpl.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public LanGuiXeResponseDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return lanGuiXeServiceImpl.getById(id);
    }

    @GetMapping("/get-all")
    public List<LanGuiXeResponseDTO> getAll() {
        return lanGuiXeServiceImpl.getAll();
    }

//    @GetMapping
//    public Page<LanGuiXeResponseDTO> query(@Valid LanGuiXeQueryRequestDTO requestDTO) {
//        return lanGuiXeService.query(requestDTO);
//    }
}
