package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class KhachRequestDTO {
    @NotNull(message = "maSoDinhDanhK can not null")
    private String maSoDinhDanhK;

    @NotNull(message = "ngheNghiep can not null")
    private String ngheNghiep;

}
