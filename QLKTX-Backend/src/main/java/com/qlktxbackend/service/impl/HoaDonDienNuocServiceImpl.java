package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.HoaDonDienNuocRequestDTO;
import com.qlktxbackend.dto.request.HoaDonDienNuocUpdateRequestDTO;
import com.qlktxbackend.dto.response.HoaDonDienNuocResponseDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.entities.HoaDonDienNuoc;
import com.qlktxbackend.repository.HoaDonDienNuocRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class HoaDonDienNuocServiceImpl {

    @Autowired
    private HoaDonDienNuocRepository hoaDonDienNuocRepository;

    public HoaDonDienNuocResponseDTO save(HoaDonDienNuocRequestDTO requestDTO) {
        HoaDonDienNuoc bean = new HoaDonDienNuoc();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = hoaDonDienNuocRepository.save(bean);
        return toResponseDTO(bean);
    }

    public boolean delete(String id) {
        hoaDonDienNuocRepository.deleteById(id);
        return true;
    }

    public boolean update(String id, HoaDonDienNuocUpdateRequestDTO requestDTO) {
        HoaDonDienNuoc bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        hoaDonDienNuocRepository.save(bean);
        return true;
    }

    public HoaDonDienNuocResponseDTO getById(String id) {
        HoaDonDienNuoc original = requireOne(id);
        return toResponseDTO(original);
    }

    public List<HoaDonDienNuocResponseDTO> getAll() {
        return hoaDonDienNuocRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    private HoaDonDienNuocResponseDTO toResponseDTO(HoaDonDienNuoc original) {
        HoaDonDienNuocResponseDTO bean = new HoaDonDienNuocResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private HoaDonDienNuoc requireOne(String id) {
        return hoaDonDienNuocRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
