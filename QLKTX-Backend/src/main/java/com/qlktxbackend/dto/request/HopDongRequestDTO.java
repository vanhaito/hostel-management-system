package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
public class HopDongRequestDTO {
    @NotNull(message = "maHopDong can not null")
    private String maHopDong;

    @NotNull(message = "ngayBatDau can not null")
    private Date ngayBatDau;

    @NotNull(message = "ngayKetThuc can not null")
    private Date ngayKetThuc;

    @NotNull(message = "maSv can not null")
    private String maSv;

    @NotNull(message = "maSoDinhDanhN can not null")
    private String maSoDinhDanhN;

    @NotNull(message = "tenPhong can not null")
    private String tenPhong;

    @NotNull(message = "tenKtx can not null")
    private String tenKtx;

}
