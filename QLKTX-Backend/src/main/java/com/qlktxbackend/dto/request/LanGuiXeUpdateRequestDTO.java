package com.qlktxbackend.dto.request;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class LanGuiXeUpdateRequestDTO extends LanGuiXeRequestDTO {
    @NotNull(message = "maLanGui can not null")
    private Integer maLanGui;
}
