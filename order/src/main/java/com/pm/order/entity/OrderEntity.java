package com.pm.order.entity;

import com.pm.common.dto.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = OrderEntity.TABLE_NAME)
@Getter
@Setter
public class OrderEntity {
    public static final String TABLE_NAME= "order";
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetailEntity> orderDetails;
}
