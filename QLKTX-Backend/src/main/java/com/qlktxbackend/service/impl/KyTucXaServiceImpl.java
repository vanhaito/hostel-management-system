package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.KyTucXaRequestDTO;
import com.qlktxbackend.dto.request.KyTucXaUpdateRequestDTO;
import com.qlktxbackend.dto.response.KyTucXaResponseDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.entities.KyTucXa;
import com.qlktxbackend.repository.KyTucXaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class KyTucXaServiceImpl {

    @Autowired
    private KyTucXaRepository kyTucXaRepository;

    public KyTucXaResponseDTO save(KyTucXaRequestDTO requestDTO) {
        KyTucXa bean = new KyTucXa();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = kyTucXaRepository.save(bean);
        return toResponseDTO(bean);
    }

    public boolean delete(String id) {
        kyTucXaRepository.deleteById(id);
        return true;
    }

    public boolean update(String id, KyTucXaUpdateRequestDTO requestDTO) {
        KyTucXa bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        kyTucXaRepository.save(bean);
        return true;
    }

    public List<KyTucXaResponseDTO> getAll() {
        return kyTucXaRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public KyTucXaResponseDTO getById(String id) {
        KyTucXa original = requireOne(id);
        return toResponseDTO(original);
    }

    private KyTucXaResponseDTO toResponseDTO(KyTucXa original) {
        KyTucXaResponseDTO bean = new KyTucXaResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private KyTucXa requireOne(String id) {
        return kyTucXaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
