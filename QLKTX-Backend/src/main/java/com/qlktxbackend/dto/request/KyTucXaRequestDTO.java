package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class KyTucXaRequestDTO {
    @NotNull(message = "tenKyTucXa can not null")
    private String tenKyTucXa;

    @NotNull(message = "soLuongPhong can not null")
    private Integer soLuongPhong;

    @NotNull(message = "diaChi can not null")
    private String diaChi;

}
