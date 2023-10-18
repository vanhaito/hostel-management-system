package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.SinhVienRequestDTO;
import com.qlktxbackend.dto.request.SinhVienUpdateRequestDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.dto.response.SinhVienResponseDTO;
import com.qlktxbackend.entities.SinhVien;
import com.qlktxbackend.repository.SinhVienRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class SinhVienServiceImpl {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    public SinhVienResponseDTO save(SinhVienRequestDTO requestDTO) {
        SinhVien bean = new SinhVien();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = sinhVienRepository.save(bean);
        return toResponseDTO(bean);
    }

    public boolean delete(String id) {
        sinhVienRepository.deleteById(id);
        return true;
    }

    public boolean update(String id, SinhVienUpdateRequestDTO requestDTO) {
        SinhVien bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        sinhVienRepository.save(bean);
        return true;
    }

    public List<SinhVienResponseDTO> getAll() {
        return sinhVienRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public SinhVienResponseDTO getById(String id) {
        SinhVien original = requireOne(id);
        return toResponseDTO(original);
    }

//    public Page<SinhVienDTO> query(SinhVienQueryRequestDTO requestDTO) {
//        throw new UnsupportedOperationException();
//    }

    private SinhVienResponseDTO toResponseDTO(SinhVien original) {
        SinhVienResponseDTO bean = new SinhVienResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SinhVien requireOne(String id) {
        return sinhVienRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
