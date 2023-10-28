package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.LanGiatRequestDTO;
import com.qlktxbackend.dto.request.LanGiatUpdateRequestDTO;
import com.qlktxbackend.dto.response.LanGiatResponseDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.entities.LanGiat;
import com.qlktxbackend.helpers.exceptions.SystemException;
import com.qlktxbackend.repository.LanGiatRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class LanGiatServiceImpl {

    @Autowired
    private LanGiatRepository lanGiatRepository;

    public LanGiatResponseDTO save(LanGiatRequestDTO requestDTO) {
        try {
        LanGiat bean = new LanGiat();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = lanGiatRepository.save(bean);
        return toResponseDTO(bean);
    }catch (Exception exception){
        throw new SystemException(ExceptionUtils.getRootCause(exception).getMessage());
    }
    }

    public boolean delete(Integer id) {
        lanGiatRepository.deleteById(id);
        return true;
    }

    public boolean update(Integer id, LanGiatUpdateRequestDTO requestDTO) {
        LanGiat bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        lanGiatRepository.save(bean);
        return true;
    }

    public List<LanGiatResponseDTO> getAll() {
        return lanGiatRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public LanGiatResponseDTO getById(Integer id) {
        LanGiat original = requireOne(id);
        return toResponseDTO(original);
    }

    private LanGiatResponseDTO toResponseDTO(LanGiat original) {
        LanGiatResponseDTO bean = new LanGiatResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private LanGiat requireOne(Integer id) {
        return lanGiatRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
