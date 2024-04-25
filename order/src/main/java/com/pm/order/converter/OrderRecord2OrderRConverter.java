package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.model.OrderR;
import org.springframework.stereotype.Component;

@Component
public class OrderRecord2OrderRConverter extends AbstractConverter<OrderRecord, OrderR> {
    @Override
    public void populate(OrderRecord orderRecord, OrderR orderR) {
        orderR.setId(orderRecord.getId());
        orderR.setCustomerEmail(orderRecord.getCustomerEmail());
    }

    @Override
    public OrderR createFromClass() {
        return new OrderR();
    }
}
