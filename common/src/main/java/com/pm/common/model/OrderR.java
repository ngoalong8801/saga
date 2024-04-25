package com.pm.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.Set;

@Table("orderr")
@Getter
@Setter
public class OrderR {
    @PrimaryKey
    private int id;
    private String customerId;
    private String customerEmail;

    @Column("products")
    private Set<ProductR> items;
    private int totalPrice;
    private String paymentStatus;
    private String orderStatus;
    private String shippingAddress;
    private Date orderDate;
    private Date lastUpdated;
}
