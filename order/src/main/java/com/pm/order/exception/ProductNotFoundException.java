package com.pm.order.exception;

import com.pm.common.exception.AbstractErrorException;

public class ProductNotFoundException extends AbstractErrorException {
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }
}
