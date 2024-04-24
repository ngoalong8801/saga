package com.pm.common.dto.request;

import lombok.Data;

import java.util.Map;

@Data
public class OrderRequest {
    Map<Integer, Integer> productQuantities;
}
