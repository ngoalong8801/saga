package com.pm.order.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = OrderDetailEntity.TABLE_NAME)
public class OrderDetailEntity {
    public static final String TABLE_NAME= "order_detail";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ordertb_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private int curPrice;

    private int quantity;  // Quantity of the product


    // Constructors, Getters, and Setters
    public OrderDetailEntity() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}