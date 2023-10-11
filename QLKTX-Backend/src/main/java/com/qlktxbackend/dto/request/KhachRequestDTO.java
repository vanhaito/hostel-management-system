package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class KhachRequestDTO {
    @NotNull(message = "maSoDinhDanhhK can not null")
    private String maSoDinhDanhhK;

    @NotNull(message = "ngheNghiep can not null")
    private String ngheNghiep;

}
