package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.response.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderData2OrderRecordConverter extends AbstractConverter<Order, OrderRecord> {

    @Override
    public void populate(Order order, OrderRecord orderRecord) {
        orderRecord.setId(order.getId());
        orderRecord.setTotal(order.getTotal());
        orderRecord.setCustomerEmail(order.getUserEmail());
    }

    @Override
    public OrderRecord createFromClass() {
        return new OrderRecord();
    }
}
