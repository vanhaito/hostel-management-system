package com.qlktxbackend.helpers.exceptions;

import java.io.Serializable;

public class UserAuthenErrorResponse<T> implements Serializable {
    private static final long serialVersionUID = 1928342098320423L;

    private String code;
    private ErrorMessage message;
}
