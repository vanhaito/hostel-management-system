package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class SinhVienRequestDTO {
    @NotNull(message = "maSoDinhDanhS can not null")
    private String maSoDinhDanhS;

    @NotNull(message = "maSv can not null")
    private String maSv;

    @NotNull(message = "lop can not null")
    private String lop;

}
