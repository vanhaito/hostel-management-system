package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.KhachRequestDTO;
import com.qlktxbackend.dto.request.KhachUpdateRequestDTO;
import com.qlktxbackend.dto.response.KhachResponseDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.entities.Khach;
import com.qlktxbackend.entities.Nguoi;
import com.qlktxbackend.repository.KhachRepository;
import com.qlktxbackend.repository.NguoiRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class KhachServiceImpl {

    @Autowired
    private KhachRepository khachRepository;

    @Autowired
    private NguoiRepository nguoiRepository;

    public KhachResponseDTO save(KhachRequestDTO requestDTO) {
        Khach bean = new Khach();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = khachRepository.save(bean);
        Nguoi nguoi = nguoiRepository.getById(bean.getMaSoDinhDanhK());
        nguoi.setLoai("Khach");
        nguoiRepository.save(nguoi);
        return toResponseDTO(bean);
    }

    public boolean delete(String id) {
        khachRepository.deleteById(id);
        return true;
    }

    public boolean update(String id, KhachUpdateRequestDTO requestDTO) {
        Khach bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        khachRepository.save(bean);
        return true;
    }

    public KhachResponseDTO getById(String id) {
        Khach original = requireOne(id);
        return toResponseDTO(original);
    }

    public List<KhachResponseDTO> getAll() {
        return khachRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }
    private KhachResponseDTO toResponseDTO(Khach original) {
        KhachResponseDTO bean = new KhachResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Khach requireOne(String id) {
        return khachRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
