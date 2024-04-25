package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.response.Order;
import com.pm.order.entity.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderEntity2OrderRecordConverter extends AbstractConverter<OrderEntity, OrderRecord> {

    @Override
    public void populate(OrderEntity order, OrderRecord orderRecord) {
        orderRecord.setId(order.getId());
        orderRecord.setCustomerEmail(order.getUserEmail());
    }

    @Override
    public OrderRecord createFromClass() {
        return new OrderRecord();
    }
}
