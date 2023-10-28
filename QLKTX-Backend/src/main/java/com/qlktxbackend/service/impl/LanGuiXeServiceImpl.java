package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.LanGuiXeRequestDTO;
import com.qlktxbackend.dto.request.LanGuiXeUpdateRequestDTO;
import com.qlktxbackend.dto.response.LanGuiXeResponseDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.entities.LanGuiXe;
import com.qlktxbackend.helpers.exceptions.SystemException;
import com.qlktxbackend.repository.LanGuiXeRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class LanGuiXeServiceImpl {

    @Autowired
    private LanGuiXeRepository lanGuiXeRepository;

    public LanGuiXeResponseDTO save(LanGuiXeRequestDTO requestDTO) {
        try {
        LanGuiXe bean = new LanGuiXe();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = lanGuiXeRepository.save(bean);
        return toResponseDTO(bean);
    }catch (Exception exception){
        throw new SystemException(ExceptionUtils.getRootCause(exception).getMessage());
    }
    }

    public boolean delete(Integer id) {
        lanGuiXeRepository.deleteById(id);
        return true;
    }

    public boolean update(Integer id, LanGuiXeUpdateRequestDTO requestDTO) {
        LanGuiXe bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        lanGuiXeRepository.save(bean);
        return true;
    }

    public List<LanGuiXeResponseDTO> getAll() {
        return lanGuiXeRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public LanGuiXeResponseDTO getById(Integer id) {
        LanGuiXe original = requireOne(id);
        return toResponseDTO(original);
    }

    private LanGuiXeResponseDTO toResponseDTO(LanGuiXe original) {
        LanGuiXeResponseDTO bean = new LanGuiXeResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private LanGuiXe requireOne(Integer id) {
        return lanGuiXeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
