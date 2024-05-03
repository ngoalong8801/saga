package com.pm.inventory.repository;

import com.pm.inventory.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllById(Iterable<Integer> ids);
}
