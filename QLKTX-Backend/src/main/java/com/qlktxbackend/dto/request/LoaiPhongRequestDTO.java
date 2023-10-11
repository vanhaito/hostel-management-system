package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class LoaiPhongRequestDTO {
    @NotNull(message = "maLoaiPhong can not null")
    private String maLoaiPhong;

    @NotNull(message = "tenLoaiPhong can not null")
    private String tenLoaiPhong;

    @NotNull(message = "dienTich can not null")
    private String dienTich;

    @NotNull(message = "gia can not null")
    private Double gia;

    @NotNull(message = "soSvToiDa can not null")
    private Integer soSvToiDa;

}
