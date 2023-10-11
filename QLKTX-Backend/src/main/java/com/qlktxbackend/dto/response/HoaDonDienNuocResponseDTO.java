package com.qlktxbackend.dto.response;


import lombok.Data;

import java.sql.Date;

@Data
public class HoaDonDienNuocResponseDTO {
    private String maHoaDon;

    private Date ngayLapHoaDon;

    private Integer chiSoDienDau;

    private Integer chiSoDienCuoi;

    private Integer chiSoNuocDau;

    private Integer chiSoNuocCuoi;

    private Double donGiaDien;

    private Double donGiaNuoc;

    private Date ngayBatDau;

    private Date ngayKetThuc;

    private String tenKtx;

    private String tenPhong;

}
