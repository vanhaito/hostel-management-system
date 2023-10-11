package com.qlktxbackend.helpers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ResponseFactory {
    public ResponseEntity<?> success(Object data) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setErrorCode(ResponseStatusCodeEnum.SUCCESS.getCode());
        responseObject.setErrorMessage(ResponseStatusCodeEnum.SUCCESS.getMessage());
        responseObject.setData(data);
        responseObject.setTimestamp(new Date());
        return ResponseEntity.ok(responseObject);
    }
} 