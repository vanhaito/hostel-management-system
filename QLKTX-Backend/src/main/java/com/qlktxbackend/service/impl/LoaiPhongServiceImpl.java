package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.LoaiPhongRequestDTO;
import com.qlktxbackend.dto.request.LoaiPhongUpdateRequestDTO;
import com.qlktxbackend.dto.response.LoaiPhongResponseDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.entities.LoaiPhong;
import com.qlktxbackend.repository.LoaiPhongRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class LoaiPhongServiceImpl {

    @Autowired
    private LoaiPhongRepository loaiPhongRepository;

    public LoaiPhongResponseDTO save(LoaiPhongRequestDTO requestDTO) {
        LoaiPhong bean = new LoaiPhong();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = loaiPhongRepository.save(bean);
        return toResponseDTO(bean);
    }

    public boolean delete(String id) {
        loaiPhongRepository.deleteById(id);
        return true;
    }

    public boolean update(String id, LoaiPhongUpdateRequestDTO requestDTO) {
        LoaiPhong bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        loaiPhongRepository.save(bean);
        return true;
    }

    public List<LoaiPhongResponseDTO> getAll() {
        return loaiPhongRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public LoaiPhongResponseDTO getById(String id) {
        LoaiPhong original = requireOne(id);
        return toResponseDTO(original);
    }

    private LoaiPhongResponseDTO toResponseDTO(LoaiPhong original) {
        LoaiPhongResponseDTO bean = new LoaiPhongResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private LoaiPhong requireOne(String id) {
        return loaiPhongRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
