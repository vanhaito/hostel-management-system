package com.qlktxbackend.service.impl;

import com.qlktxbackend.repository.custom.ThongKeRepository;
import com.qlktxbackend.repository.custom.entity.DienNuocPhongTheoThang;
import com.qlktxbackend.repository.custom.entity.KhachTheoThang;
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
}
