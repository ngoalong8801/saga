package com.pm.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("product")
@Getter
@Setter
public class ProductR {
    @PrimaryKey
    private int productId;
    private String name;
    private int quantity;
    private int price;
}
