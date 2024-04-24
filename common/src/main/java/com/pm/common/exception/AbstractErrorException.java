package com.pm.common.exception;

public abstract class AbstractErrorException extends RuntimeException {
    private String errorCode;

    public AbstractErrorException(String message) {
        super(message);
    }

    public AbstractErrorException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

