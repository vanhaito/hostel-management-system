package com.qlktxbackend.dto.request;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class HoaDonDienNuocUpdateRequestDTO extends HoaDonDienNuocRequestDTO {
    @NotNull(message = "maHoaDon can not null")
    private String maHoaDon;
}
