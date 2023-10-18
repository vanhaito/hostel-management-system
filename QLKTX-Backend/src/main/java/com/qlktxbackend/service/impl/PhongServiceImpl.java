package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.PhongRequestDTO;
import com.qlktxbackend.dto.request.PhongUpdateRequestDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.dto.response.PhongResponseDTO;
import com.qlktxbackend.entities.Phong;
import com.qlktxbackend.entities.key.PhongKey;
import com.qlktxbackend.repository.PhongRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PhongServiceImpl {

    @Autowired
    private PhongRepository phongRepository;

    public PhongResponseDTO save(PhongRequestDTO requestDTO) {
        Phong bean = new Phong();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = phongRepository.save(bean);
        return toResponseDTO(bean);
    }

    public boolean delete(PhongKey id) {
        phongRepository.deleteById(id);
        return true;
    }

    public List<PhongResponseDTO> getAll() {
        return phongRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public boolean update(PhongKey id, PhongUpdateRequestDTO requestDTO) {
        Phong bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        phongRepository.save(bean);
        return true;
    }

    public PhongResponseDTO getById(PhongKey id) {
        Phong original = requireOne(id);
        return toResponseDTO(original);
    }

//    public Page<PhongDTO> query(PhongQueryRequestDTO requestDTO) {
//        throw new UnsupportedOperationException();
//    }

    private PhongResponseDTO toResponseDTO(Phong original) {
        PhongResponseDTO bean = new PhongResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Phong requireOne(PhongKey id) {
        return phongRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
