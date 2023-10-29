package com.qlktxbackend.dto.request;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class HopDongUpdateRequestDTO extends HopDongRequestDTO {
    @NotNull(message = "maHopDong can not null")
    private String maHopDong;
}
