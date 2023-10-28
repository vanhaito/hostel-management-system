package com.qlktxbackend.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
public class NguoiRequestDTO {
    @NotNull(message = "maSoDinhDanh can not null")
    private String maSoDinhDanh;

    @NotNull(message = "ngaySinh can not null")
    private Date ngaySinh;

    @NotNull(message = "hoTen can not null")
    private String hoTen;

    @NotNull(message = "gioiTinh can not null")
    private String gioiTinh;

    @NotNull(message = "diaChiThuongChu can not null")
    private String diaChiThuongChu;

//    @NotNull(message = "loai can not null")
//    private String loai;

}
