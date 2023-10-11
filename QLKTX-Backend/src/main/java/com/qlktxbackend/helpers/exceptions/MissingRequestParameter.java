package com.qlktxbackend.helpers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingRequestParameter extends RuntimeException{
    public MissingRequestParameter(String message) {
        super(message);
    }

    public MissingRequestParameter(String message, Throwable cause) {
        super(message, cause);
    }
}
