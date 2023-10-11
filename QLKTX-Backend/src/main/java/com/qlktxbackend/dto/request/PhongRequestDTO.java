package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class PhongRequestDTO {
    @NotNull(message = "tenKyTucXa can not null")
    private String tenKyTucXa;

    @NotNull(message = "tenPhong can not null")
    private String tenPhong;

    @NotNull(message = "soSvHienCo can not null")
    private Integer soSvHienCo;

    @NotNull(message = "tang can not null")
    private Integer tang;

    @NotNull(message = "maLoaiPhong can not null")
    private String maLoaiPhong;

}
