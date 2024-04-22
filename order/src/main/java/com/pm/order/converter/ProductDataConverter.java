package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.Product;
import com.pm.order.entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductDataConverter extends AbstractConverter<Product, ProductEntity> {
    @Override
    public void populate(Product product, ProductEntity entity) {
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setThreshold(product.getThreshold());
    }

    @Override
    public ProductEntity createFromClass() {
        return new ProductEntity();
    }
}
