package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.NhanVienQlRequestDTO;
import com.qlktxbackend.dto.request.NhanVienQlUpdateRequestDTO;
import com.qlktxbackend.dto.response.NguoiResponseDTO;
import com.qlktxbackend.dto.response.NhanVienQlResponseDTO;
import com.qlktxbackend.entities.NhanVienQl;
import com.qlktxbackend.repository.NhanVienQlRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class NhanVienQlServiceImpl {

    @Autowired
    private NhanVienQlRepository nhanVienQlRepository;


    public NhanVienQlResponseDTO save(NhanVienQlRequestDTO requestDTO) {
        NhanVienQl bean = new NhanVienQl();
        BeanUtils.copyProperties(requestDTO, bean);
        bean = nhanVienQlRepository.save(bean);
        return toResponseDTO(bean);
    }

    public boolean delete(String id) {
        nhanVienQlRepository.deleteById(id);
        return true;
    }

    public boolean update(String id, NhanVienQlUpdateRequestDTO requestDTO) {
        NhanVienQl bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        nhanVienQlRepository.save(bean);
        return true;
    }

    public List<NhanVienQlResponseDTO> getAll() {
        return nhanVienQlRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public NhanVienQlResponseDTO getById(String id) {
        NhanVienQl original = requireOne(id);
        return toResponseDTO(original);
    }

//    public Page<NhanVienQlDTO> query(NhanVienQlQueryRequestDTO requestDTO) {
//        throw new UnsupportedOperationException();
//    }

    private NhanVienQlResponseDTO toResponseDTO(NhanVienQl original) {
        NhanVienQlResponseDTO bean = new NhanVienQlResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private NhanVienQl requireOne(String id) {
        return nhanVienQlRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
