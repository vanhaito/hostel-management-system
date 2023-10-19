package com.qlktxbackend.dto.request;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class LanGiatUpdateRequestDTO extends LanGiatRequestDTO {
    @NotNull(message = "maLuotGiat can not null")
    private Integer maLuotGiat;
}
