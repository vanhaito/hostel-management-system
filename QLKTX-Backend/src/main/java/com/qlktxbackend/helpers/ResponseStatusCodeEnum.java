package com.qlktxbackend.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatusCodeEnum {
    SUCCESS("0", "Success"),
    BAD_REQUEST("400", "Invalid Parameter"),
    UNAUTHORIZED("401", "Unauthorized"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found Info"),
    METHOD_NOT_ALLOWED("405", "method is not allow"),
    INTERNAL_SERVER_ERROR("500", "Internal Server Error"),
    NOT_IMPLEMENTED("501", "Not Implemented"),
    CONFLICT("505", "Conflict");

    private String code;
    private String message;
}

