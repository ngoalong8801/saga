package com.pm.order.populator;

import com.pm.common.converters.Populator;
import com.pm.order.entity.OrderDetailEntity;
import com.pm.order.entity.OrderEntity;
import org.springframework.core.convert.ConversionException;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailPopulator implements Populator<OrderEntity, OrderDetailEntity> {
    @Override
    public void populate(OrderEntity orderEntity, OrderDetailEntity orderDetailEntity) throws ConversionException {
        orderDetailEntity.setOrder(orderEntity);
    }
}
