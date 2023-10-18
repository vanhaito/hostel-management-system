package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.NguoiRequestDTO;
import com.qlktxbackend.dto.request.NguoiUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.service.impl.NguoiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/nguoi")
public class NguoiController {

    @Autowired
    private NguoiServiceImpl nguoiService;

    @PostMapping
    public NguoiResponseDTO save(@Valid @RequestBody NguoiRequestDTO requestDTO) {
        return nguoiService.save(requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@Valid @NotNull @PathVariable("id") String id) {
        return nguoiService.delete(id);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody NguoiUpdateRequestDTO requestDTO) {
        return nguoiService.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public NguoiResponseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return nguoiService.getById(id);
    }

    @GetMapping("/get-all")
    public List<NguoiResponseDTO> getAll() {
        return nguoiService.getAll();
    }

//    @GetMapping
//    public Page<NguoiResponseDTO> query(@Valid NguoiQueryRequestDTO requestDTO) {
//        return nguoiService.query(requestDTO);
//    }
}
