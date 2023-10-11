package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class LanGiatRequestDTO {
    @NotNull(message = "maLuotGiat can not null")
    private Integer maLuotGiat;

    @NotNull(message = "donGia can not null")
    private Double donGia;

    @NotNull(message = "khoiLuong can not null")
    private Double khoiLuong;

    @NotNull(message = "ngayGiat can not null")
    private Date ngayGiat;

    @NotNull(message = "maSv can not null")
    private String maSv;

}
