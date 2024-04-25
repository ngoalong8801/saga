package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.event.ProductRecord;
import com.pm.common.dto.request.ProductQRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductQRequest2ProductRecordConverter extends AbstractConverter<ProductQRequest, ProductRecord> {
    @Override
    public void populate(ProductQRequest productQRequest, ProductRecord productRecord) {
        productRecord.setId(productQRequest.getId());
        productRecord.setQuantity(productQRequest.getQuantity());
    }

    @Override
    public ProductRecord createFromClass() {
        return new ProductRecord();
    }
}
