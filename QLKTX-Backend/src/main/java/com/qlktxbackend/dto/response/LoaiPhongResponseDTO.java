package com.qlktxbackend.dto.response;


import lombok.Data;

@Data
public class LoaiPhongResponseDTO {
    private String maLoaiPhong;

    private String tenLoaiPhong;

    private String dienTich;

    private Double gia;

    private Integer soSvToiDa;

}
