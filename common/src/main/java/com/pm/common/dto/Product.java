package com.pm.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Product {
    String name;
    int price;
    int threshold;
}
