package com.qlktxbackend.repository.custom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TongTienSVTheoThang {
    private String maSinhVien;
    private String hoTen;
    private String lop;
    private String tenPhong;
    private String tenKtx;
    private Double tongTien;
}
