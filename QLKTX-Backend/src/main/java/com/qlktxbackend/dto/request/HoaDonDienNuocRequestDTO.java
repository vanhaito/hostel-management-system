package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
public class HoaDonDienNuocRequestDTO {

    @NotNull(message = "ngayLapHoaDon can not null")
    private Date ngayLapHoaDon;

    @NotNull(message = "chiSoDienDau can not null")
    private Integer chiSoDienDau;

    @NotNull(message = "chiSoDienCuoi can not null")
    private Integer chiSoDienCuoi;

    @NotNull(message = "chiSoNuocDau can not null")
    private Integer chiSoNuocDau;

    @NotNull(message = "chiSoNuocCuoi can not null")
    private Integer chiSoNuocCuoi;

    @NotNull(message = "donGiaDien can not null")
    private Double donGiaDien;

    @NotNull(message = "donGiaNuoc can not null")
    private Double donGiaNuoc;

    @NotNull(message = "ngayBatDau can not null")
    private Date ngayBatDau;

    @NotNull(message = "ngayKetThuc can not null")
    private Date ngayKetThuc;

    @NotNull(message = "tenKtx can not null")
    private String tenKtx;

    @NotNull(message = "tenPhong can not null")
    private String tenPhong;

}
