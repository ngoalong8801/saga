package com.pm.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = ProductEntity.TABLE_NAME)
@Getter
@Setter
public class ProductEntity {
    public static final String TABLE_NAME= "product";
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private int threshold;
    private int price;
}
