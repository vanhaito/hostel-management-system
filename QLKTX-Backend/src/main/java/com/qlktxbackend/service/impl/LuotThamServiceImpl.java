package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.LuotThamRequestDTO;
import com.qlktxbackend.dto.request.LuotThamUpdateRequestDTO;
import com.qlktxbackend.dto.response.LuotThamResponseDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.entities.LuotTham;
import com.qlktxbackend.helpers.exceptions.SystemException;
import com.qlktxbackend.repository.LuotThamRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class LuotThamServiceImpl {

    @Autowired
    private LuotThamRepository luotThamRepository;

    public LuotThamResponseDTO save(LuotThamRequestDTO requestDTO) {
        try {
        LuotTham bean = new LuotTham();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = luotThamRepository.save(bean);
        return toResponseDTO(bean);
    }catch (Exception exception){
        throw new SystemException(ExceptionUtils.getRootCause(exception).getMessage());
    }
    }

    public boolean delete(Integer id) {
        luotThamRepository.deleteById(id);
        return true;
    }

    public boolean update(Integer id, LuotThamUpdateRequestDTO requestDTO) {
        LuotTham bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        luotThamRepository.save(bean);
        return true;
    }

    public List<LuotThamResponseDTO> getAll() {
        return luotThamRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public LuotThamResponseDTO getById(Integer id) {
        LuotTham original = requireOne(id);
        return toResponseDTO(original);
    }

    private LuotThamResponseDTO toResponseDTO(LuotTham original) {
        LuotThamResponseDTO bean = new LuotThamResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private LuotTham requireOne(Integer id) {
        return luotThamRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
