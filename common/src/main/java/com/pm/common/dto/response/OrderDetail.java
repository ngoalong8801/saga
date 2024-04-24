package com.pm.common.dto.response;

import com.pm.common.dto.Product;
import lombok.Data;

@Data
public class OrderDetail {
    Product product;
    int quantity;
    int price;
}
