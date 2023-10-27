package com.qlktxbackend.repository.custom.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachTheoThang {
    private String maSv;
    private String lop;
    private Date ngaySinh;
    private String maSoDinhDanhS;
    private String maSoDinhDanhK;
    private String ngheNghiep;
    private String hoTen;
    private String gioiTinh;
    private String diaChiThuongChu;
    private Integer soLuotTham;
}
