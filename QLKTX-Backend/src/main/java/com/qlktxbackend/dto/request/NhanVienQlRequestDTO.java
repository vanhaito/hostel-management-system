package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class NhanVienQlRequestDTO {
    @NotNull(message = "maSoDinhDanhN can not null")
    private String maSoDinhDanhN;

    @NotNull(message = "trinhDo can not null")
    private String trinhDo;

    @NotNull(message = "tenKyTucXa can not null")
    private String tenKyTucXa;

}
