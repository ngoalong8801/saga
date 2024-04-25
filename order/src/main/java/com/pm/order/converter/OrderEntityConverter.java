package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.response.Order;
import com.pm.order.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderEntityConverter extends AbstractConverter<OrderEntity, Order> {
    @Autowired
    OrderDetailEntityConverter orderDetailEntityConverter;

    @Override
    public void populate(OrderEntity orderEntity, Order order) {
        order.setId(orderEntity.getId());
        order.setMessage("Your order is being processed.");
        order.setStatus(orderEntity.getStatus());
    }

    @Override
    public Order createFromClass() {
        return new Order();
    }
}
