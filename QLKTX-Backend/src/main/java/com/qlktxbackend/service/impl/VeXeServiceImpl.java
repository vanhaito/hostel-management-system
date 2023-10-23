package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.VeXeRequestDTO;
import com.qlktxbackend.dto.request.VeXeUpdateRequestDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.dto.response.VeXeResponseDTO;
import com.qlktxbackend.entities.VeXe;
import com.qlktxbackend.helpers.exceptions.SystemException;
import com.qlktxbackend.repository.VeXeRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class VeXeServiceImpl {

    @Autowired
    private VeXeRepository veXeRepository;

    public VeXeResponseDTO save(VeXeRequestDTO requestDTO) {
        try {
            VeXe bean = new VeXe();
            BeanUtils.copyProperties(requestDTO, bean);
            bean = veXeRepository.save(bean);
            return toResponseDTO(bean);
        }catch (Exception exception){
            throw new SystemException(ExceptionUtils.getRootCause(exception).getMessage());
        }
    }

    public boolean delete(String id) {
        veXeRepository.deleteById(id);
        return true;
    }

    public boolean update(String id, VeXeUpdateRequestDTO requestDTO) {
        VeXe bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        veXeRepository.save(bean);
        return true;
    }

    public VeXeResponseDTO getById(String id) {
        VeXe original = requireOne(id);
        return toResponseDTO(original);
    }

//    public Page<VeXeDTO> query(VeXeQueryRequestDTO requestDTO) {
//        throw new UnsupportedOperationException();
//    }

    public List<VeXeResponseDTO> getAll() {
        return veXeRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    private VeXeResponseDTO toResponseDTO(VeXe original) {
        VeXeResponseDTO bean = new VeXeResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VeXe requireOne(String id) {
        return veXeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
