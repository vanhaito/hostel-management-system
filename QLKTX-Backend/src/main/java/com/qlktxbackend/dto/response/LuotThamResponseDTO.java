package com.qlktxbackend.dto.response;


import lombok.Data;

import java.util.Date;

@Data
public class LuotThamResponseDTO {
    private Integer maLuotTham;

    private Date thoiGianDen;

    private Date thoiGianDi;

    private String maSv;

    private String maSoDinhDanhK;

}
