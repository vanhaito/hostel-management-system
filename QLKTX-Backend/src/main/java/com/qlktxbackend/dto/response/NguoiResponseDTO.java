package com.qlktxbackend.dto.response;


import lombok.Data;

import java.sql.Date;

@Data
public class NguoiResponseDTO {
    private String maSoDinhDanh;

    private Date ngaySinh;

    private String hoTen;

    private String gioiTinh;

    private String diaChiThuongChu;

    private String loai;

}
