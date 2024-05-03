package com.pm.inventory.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.event.ProductRecord;
import com.pm.common.model.ProductR;
import com.pm.inventory.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductEntity2ProductRConverter extends AbstractConverter<ProductEntity, ProductR> {

    @Override
    public void populate(ProductEntity productEntity, ProductR productR) {
        productR.setProductId(productEntity.getId());
        productR.setName(productEntity.getName());
        productR.setPrice(productEntity.getPrice());

    }

    @Override
    public ProductR createFromClass() {
        return new ProductR();
    }
}
