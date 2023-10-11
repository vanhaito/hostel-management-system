package com.qlktxbackend.dto.response;


import lombok.Data;

import java.util.Date;

@Data
public class LanGiatResponseDTO {
    private Integer maLuotGiat;

    private Double donGia;

    private Double khoiLuong;

    private Date ngayGiat;

    private String maSv;

}
