package com.qlktxbackend.dto.response;


import lombok.Data;

import java.sql.Date;

@Data
public class HopDongResponseDTO {
    private String maHopDong;

    private Date ngayBatDau;

    private Date ngayKetThuc;

    private String maSv;

    private String maSoDinhDanhN;

    private String tenPhong;

    private String tenKtx;

}
