package com.pm.inventory.exception.handler;

import com.pm.common.dto.Product;
import com.pm.common.dto.response.Response;
import com.pm.common.utils.Utils;
import com.pm.inventory.exception.ProductExceedThresholdException;
import com.pm.inventory.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {
    @Autowired
    Utils<Product> productUtils;

    @ExceptionHandler({ProductExceedThresholdException.class, ProductNotFoundException.class})
    public ResponseEntity<Response<Product>> handleProductNotFoundException(ProductExceedThresholdException ex) {
        return productUtils.generateFailedResponse(ex.getMessage());
    }
}
