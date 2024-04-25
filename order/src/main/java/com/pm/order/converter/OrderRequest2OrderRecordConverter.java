package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRequest2OrderRecordConverter extends AbstractConverter<OrderRequest, OrderRecord> {
    @Autowired
    ProductQRequest2ProductRecordConverter productQRequest2ProductRecordConverter;
    @Override
    public void populate(OrderRequest request, OrderRecord orderRecord) {
        orderRecord.setPaymentMethod(request.getPaymentMethod());
        orderRecord.setItems(productQRequest2ProductRecordConverter.convertAll(request.getItems()));
    }

    @Override
    public OrderRecord createFromClass() {
        return new OrderRecord();
    }
}
