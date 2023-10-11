package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class VeXeRequestDTO {
    @NotNull(message = "bienSoXe can not null")
    private String bienSoXe;

    @NotNull(message = "loaiXe can not null")
    private String loaiXe;

    @NotNull(message = "mauXe can not null")
    private String mauXe;

    @NotNull(message = "trangThai can not null")
    private Integer trangThai;

    @NotNull(message = "maSv can not null")
    private String maSv;

}
