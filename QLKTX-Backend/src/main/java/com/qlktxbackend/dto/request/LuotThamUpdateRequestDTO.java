package com.qlktxbackend.dto.request;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class LuotThamUpdateRequestDTO extends LuotThamRequestDTO {
    @NotNull(message = "maLuotTham can not null")
    private Integer maLuotTham;
}
