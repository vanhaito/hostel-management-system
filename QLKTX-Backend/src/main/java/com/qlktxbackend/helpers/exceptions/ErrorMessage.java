package com.qlktxbackend.helpers.exceptions;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
    private String en;
    private String vi;

    public ErrorMessage(){

    }

    public ErrorMessage(String en, String vi){
        this.en = en;
        this.vi = vi;
    }
}
