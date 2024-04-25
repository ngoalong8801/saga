package com.pm.common.dto.request;

import com.pm.common.dto.event.ProductRecord;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrderRequest {
    private String customerEmail;
    List<ProductQRequest> items;
    String paymentMethod;
}
