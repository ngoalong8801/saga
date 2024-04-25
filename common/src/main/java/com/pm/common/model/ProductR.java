package com.pm.common.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("product")
public class ProductR {
    @PrimaryKey
    private String productId;
    private String name;
    private int quantity;
    private int price;
}
