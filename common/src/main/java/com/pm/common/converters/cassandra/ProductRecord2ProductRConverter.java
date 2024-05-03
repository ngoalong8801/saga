package com.pm.common.converters.cassandra;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.event.ProductRecord;
import com.pm.common.model.ProductR;
import org.springframework.stereotype.Component;

@Component
public class ProductRecord2ProductRConverter extends AbstractConverter<ProductRecord, ProductR> {
    @Override
    public void populate(ProductRecord productRecord, ProductR productR) {
        productR.setQuantity(productRecord.getQuantity());
    }

    @Override
    public ProductR createFromClass() {
        return new ProductR();
    }
}
