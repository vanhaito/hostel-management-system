package com.qlktxbackend.repository.custom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DienNuocPhongTheoThang {
    private String tenKyTucXa;
    private String tenPhong;
    private Integer soSvHienCo;
    private Integer tang;
    private String maLoaiPhong;
    private Double tienDien;
    private Double tienNuoc;
}
