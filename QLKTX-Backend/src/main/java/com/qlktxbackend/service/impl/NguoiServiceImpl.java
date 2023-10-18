package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.NguoiRequestDTO;
import com.qlktxbackend.dto.request.NguoiUpdateRequestDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.entities.Nguoi;
import com.qlktxbackend.repository.NguoiRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class NguoiServiceImpl {

    @Autowired
    private NguoiRepository nguoiRepository;

    public NguoiResponseDTO save(NguoiRequestDTO requestDTO) {
        Nguoi bean = new Nguoi();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = nguoiRepository.save(bean);
        return toResponseDTO(bean);
    }

    public boolean delete(String id) {
        nguoiRepository.deleteById(id);
        return true;
    }

    public boolean update(String id, NguoiUpdateRequestDTO requestDTO) {
        Nguoi bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        bean = nguoiRepository.save(bean);
        return true;
    }

    public NguoiResponseDTO getById(String id) {
        Nguoi original = requireOne(id);
        return toResponseDTO(original);
    }

    public List<NguoiResponseDTO> getAll() {
        return nguoiRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    private NguoiResponseDTO toResponseDTO(Nguoi original) {
        NguoiResponseDTO bean = new NguoiResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Nguoi requireOne(String id) {
        return nguoiRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
