package com.pm.inventory.exception;

import com.pm.common.exception.AbstractErrorException;

public class ProductExceedThresholdException extends AbstractErrorException {
    public ProductExceedThresholdException(String message) {
        super(message);
    }

    public ProductExceedThresholdException(String message, String errorCode) {
        super(message, errorCode);
    }
}
