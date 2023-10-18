package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.NguoiSdtRequestDTO;
import com.qlktxbackend.dto.request.NguoiSdtUpdateRequestDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.dto.response.NguoiSdtResponseDTO;
import com.qlktxbackend.entities.NguoiSdt;
import com.qlktxbackend.entities.key.NguoiSdtKey;
import com.qlktxbackend.repository.NguoiSdtRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class NguoiSdtServiceImpl {

    @Autowired
    private NguoiSdtRepository nguoiSdtRepository;

    public NguoiSdtResponseDTO save(NguoiSdtRequestDTO requestDTO) {
        NguoiSdt bean = new NguoiSdt();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = nguoiSdtRepository.save(bean);
        return toResponseDTO(bean);
    }

    public boolean delete(NguoiSdtKey id) {
        nguoiSdtRepository.deleteById(id);
        return true;
    }

    public boolean update(NguoiSdtKey id, NguoiSdtUpdateRequestDTO requestDTO) {
        NguoiSdt bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        nguoiSdtRepository.save(bean);
        return true;
    }

    public List<NguoiSdtResponseDTO> getAll() {
        return nguoiSdtRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public NguoiSdtResponseDTO getById(NguoiSdtKey id) {
        NguoiSdt original = requireOne(id);
        return toResponseDTO(original);
    }

    private NguoiSdtResponseDTO toResponseDTO(NguoiSdt original) {
        NguoiSdtResponseDTO bean = new NguoiSdtResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private NguoiSdt requireOne(NguoiSdtKey id) {
        return nguoiSdtRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
