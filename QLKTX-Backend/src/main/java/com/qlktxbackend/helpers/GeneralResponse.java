package com.qlktxbackend.helpers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class GeneralResponse<T> implements Serializable {

    //    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    @JsonProperty("message")
    private String errorMessage;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("data")
    private T data;
}