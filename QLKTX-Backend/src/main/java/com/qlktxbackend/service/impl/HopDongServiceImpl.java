package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.HopDongRequestDTO;
import com.qlktxbackend.dto.request.HopDongUpdateRequestDTO;
import com.qlktxbackend.dto.response.HopDongResponseDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.entities.HopDong;
import com.qlktxbackend.repository.HopDongRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class HopDongServiceImpl {

    @Autowired
    private HopDongRepository hopDongRepository;

    public HopDongResponseDTO save(HopDongRequestDTO requestDTO) {
        HopDong bean = new HopDong();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = hopDongRepository.save(bean);
        return toResponseDTO(bean);
    }

    public boolean delete(String id) {
        hopDongRepository.deleteById(id);
        return true;
    }

    public boolean update(String id, HopDongUpdateRequestDTO requestDTO) {
        HopDong bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        hopDongRepository.save(bean);
        return true;
    }

    public HopDongResponseDTO getById(String id) {
        HopDong original = requireOne(id);
        return toResponseDTO(original);
    }

    public List<HopDongResponseDTO> getAll() {
        return hopDongRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }
    private HopDongResponseDTO toResponseDTO(HopDong original) {
        HopDongResponseDTO bean = new HopDongResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private HopDong requireOne(String id) {
        return hopDongRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
