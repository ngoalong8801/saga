package com.pm.order.repository;

import com.pm.order.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}
