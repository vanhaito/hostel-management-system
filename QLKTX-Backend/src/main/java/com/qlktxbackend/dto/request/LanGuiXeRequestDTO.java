package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class LanGuiXeRequestDTO {

    @NotNull(message = "thoiGianGui can not null")
    private Date thoiGianGui;

    @NotNull(message = "thoiGianLay can not null")
    private Date thoiGianLay;

    @NotNull(message = "bienSoXe can not null")
    private String bienSoXe;

    @NotNull(message = "maSv can not null")
    private String maSv;

}
