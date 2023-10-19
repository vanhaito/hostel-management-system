package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class LuotThamRequestDTO {

    @NotNull(message = "thoiGianDen can not null")
    private Date thoiGianDen;

    @NotNull(message = "thoiGianDi can not null")
    private Date thoiGianDi;

    @NotNull(message = "maSv can not null")
    private String maSv;

    @NotNull(message = "maSoDinhDanhK can not null")
    private String maSoDinhDanhK;

}
