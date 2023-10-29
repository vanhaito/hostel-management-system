package com.qlktxbackend.service.impl;

import com.qlktxbackend.repository.custom.ThongKeRepository;
import com.qlktxbackend.repository.custom.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ThongKeServiceImpl {

    @Autowired
    private ThongKeRepository thongKeRepository;

    public List<KhachTheoThang>  getThongKeKhachTheoThang(Integer month, Integer year) {
        return thongKeRepository.thongKeKhachTheoThang(month, year);
    }

    public List<DienNuocPhongTheoThang>  getThongKeTienDienNuocTheoThang(Integer month, Integer year) {
        return thongKeRepository.thongKeTienDienNuocTheoThang(month, year);
    }

    public List<TongTienSVTheoThang>  getThongKeTongTienSVTheoThang(Integer month, Integer year) {
        return thongKeRepository.thongKeTongTienSVTheoThang(month, year);
    }

    public List<TienDichVuSVTheoThang>  getThongKeTienDichVuSVTheoThang(Integer month, Integer year) {
        return thongKeRepository.thongKeTienDichVuSVTheoThang(month, year);
    }

    public List<TongTienDichVuKtxTheoThang> getThongKeTongTienDichVuKtxTheoThang(Integer month, Integer year) {
        return thongKeRepository.thongKeTongTienDichVuKtxTheoThang(month, year);
    }
}
