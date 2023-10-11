package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class NguoiSdtRequestDTO {
    @NotNull(message = "maSoDinhDanh can not null")
    private String maSoDinhDanh;

    @NotNull(message = "soDienThoai can not null")
    private String soDienThoai;

}
