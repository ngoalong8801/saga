package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.Product;
import com.pm.order.entity.ProductEntity;
import org.springframework.core.convert.ConversionException;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityConverter extends AbstractConverter<ProductEntity, Product> {

    @Override
    public void populate(ProductEntity productEntity, Product product) {
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setThreshold(productEntity.getThreshold());
    }

    @Override
    public Product createFromClass() {
        return new Product();
    }
}
