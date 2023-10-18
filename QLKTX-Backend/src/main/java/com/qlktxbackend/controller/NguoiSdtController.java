package com.qlktxbackend.controller;

import com.qlktxbackend.dto.request.NguoiSdtRequestDTO;
import com.qlktxbackend.dto.request.NguoiSdtUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.NguoiSdtResponseDTO;
import com.qlktxbackend.entities.key.NguoiSdtKey;
import com.qlktxbackend.service.impl.NguoiSdtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/nguoi-sdt")
public class NguoiSdtController {

    @Autowired
    private NguoiSdtServiceImpl nguoiSdtService;

    @PostMapping
    public NguoiSdtResponseDTO save(@Valid @RequestBody NguoiSdtRequestDTO requestDTO) {
        return nguoiSdtService.save(requestDTO);
    }

    @DeleteMapping("/{maSoDinhDanh}/{soDienThoai}")
    public boolean delete(@Valid @NotNull @PathVariable("maSoDinhDanh") String maSoDinhDanh,
                       @Valid @NotNull @PathVariable("soDienThoai") String soDienThoai) {
        NguoiSdtKey nguoiSdtKey = NguoiSdtKey.builder().soDienThoai(soDienThoai).maSoDinhDanh(maSoDinhDanh).build();
        return nguoiSdtService.delete(nguoiSdtKey);
    }

    @PutMapping("/{maSoDinhDanh}/{soDienThoai}")
    public boolean update(@Valid @NotNull @PathVariable("maSoDinhDanh") String maSoDinhDanh,
                       @Valid @NotNull @PathVariable("soDienThoai") String soDienThoai,
                       @Valid @RequestBody NguoiSdtUpdateRequestDTO requestDTO) {
        NguoiSdtKey nguoiSdtKey = NguoiSdtKey.builder().soDienThoai(soDienThoai).maSoDinhDanh(maSoDinhDanh).build();
        return nguoiSdtService.update(nguoiSdtKey, requestDTO);
    }

    @GetMapping("/{maSoDinhDanh}/{soDienThoai}")
    public NguoiSdtResponseDTO getById(@Valid @NotNull @PathVariable("maSoDinhDanh") String maSoDinhDanh,
                                       @Valid @NotNull @PathVariable("soDienThoai") String soDienThoai) {
        NguoiSdtKey nguoiSdtKey = NguoiSdtKey.builder().soDienThoai(soDienThoai).maSoDinhDanh(maSoDinhDanh).build();
        return nguoiSdtService.getById(nguoiSdtKey);
    }

    @GetMapping("/get-all")
    public List<NguoiSdtResponseDTO> getAll() {
        return nguoiSdtService.getAll();
    }

//    @GetMapping
//    public Page<NguoiSdtResponseDTO> query(@Valid NguoiSdtQueryRequestDTO requestDTO) {
//        return nguoiSdtService.query(requestDTO);
//    }
}
