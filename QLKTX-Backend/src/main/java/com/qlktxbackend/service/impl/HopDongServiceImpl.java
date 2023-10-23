package com.qlktxbackend.service.impl;

import com.qlktxbackend.dto.request.HopDongRequestDTO;
import com.qlktxbackend.dto.request.HopDongUpdateRequestDTO;
import com.qlktxbackend.dto.response.HopDongResponseDTO;
import com.qlktxbackend.entities.HopDong;
import com.qlktxbackend.entities.Phong;
import com.qlktxbackend.entities.key.PhongKey;
import com.qlktxbackend.helpers.exceptions.SystemException;
import com.qlktxbackend.repository.HopDongRepository;
import com.qlktxbackend.repository.PhongRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class HopDongServiceImpl {

    @Autowired
    private HopDongRepository hopDongRepository;

    @Autowired
    private PhongRepository phongRepository;

    public HopDongResponseDTO save(HopDongRequestDTO requestDTO) {
        try {
            HopDong bean = new HopDong();
            BeanUtils.copyProperties(requestDTO, bean);
            bean = hopDongRepository.save(bean);

            Phong phong = phongRepository.getById(PhongKey.builder().tenPhong(bean.getTenPhong()).tenKyTucXa(bean.getTenKtx()).build());
            phong.setSoSvHienCo(phong.getSoSvHienCo()+1);
            phongRepository.save(phong);
            return toResponseDTO(bean);
        } catch (Exception exception) {
            throw new SystemException(ExceptionUtils.getRootCause(exception).getMessage());
        }
    }

    public boolean delete(String id) {
        HopDong bean = hopDongRepository.getById(id);
        hopDongRepository.deleteById(id);
        Phong phong = phongRepository.getById(PhongKey.builder().tenPhong(bean.getTenPhong()).tenKyTucXa(bean.getTenKtx()).build());
        phong.setSoSvHienCo(phong.getSoSvHienCo()-1);
        phongRepository.save(phong);
        return true;
    }

    public boolean update(String id, HopDongUpdateRequestDTO requestDTO) {
        HopDong bean = requireOne(id);
        BeanUtils.copyProperties(requestDTO, bean);
        hopDongRepository.save(bean);
        return true;
    }

    public HopDongResponseDTO getById(String id) {
        HopDong original = requireOne(id);
        return toResponseDTO(original);
    }

    public List<HopDongResponseDTO> getAll() {
        return hopDongRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    private HopDongResponseDTO toResponseDTO(HopDong original) {
        HopDongResponseDTO bean = new HopDongResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private HopDong requireOne(String id) {
        return hopDongRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
