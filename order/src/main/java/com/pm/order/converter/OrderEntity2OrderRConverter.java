package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.model.OrderR;
import com.pm.order.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderEntity2OrderRConverter extends AbstractConverter<OrderEntity, OrderR> {
    @Override
    public void populate(OrderEntity orderEntity, OrderR orderR) {
        orderR.setId(orderEntity.getId());
        orderR.setCustomerEmail(orderEntity.getUserEmail());
    }

    @Override
    public OrderR createFromClass() {
        return new OrderR();
    }
}
