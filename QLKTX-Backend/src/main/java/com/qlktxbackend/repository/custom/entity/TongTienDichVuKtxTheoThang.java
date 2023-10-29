package com.qlktxbackend.repository.custom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TongTienDichVuKtxTheoThang {
    private String kyTucXa;
    private String dichVu;
    private Double doanhThu;
}
