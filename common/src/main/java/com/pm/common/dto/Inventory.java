package com.pm.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data
public class Inventory {
    Map<Product, Integer> productQuantities;
    public Inventory() {
        this.productQuantities = new HashMap<>();
    }
}
