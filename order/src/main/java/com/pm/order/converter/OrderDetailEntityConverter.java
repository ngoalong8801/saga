package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.common.dto.response.OrderDetail;
import com.pm.order.entity.OrderDetailEntity;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailEntityConverter extends AbstractConverter<OrderDetailEntity, OrderDetail> {
    @Autowired
    ProductEntityConverter productEntityConverter;

    @Override
    public void populate(OrderDetailEntity orderDetailEntity, OrderDetail orderDetail) {
        orderDetail.setPrice(orderDetailEntity.getCurPrice());
        orderDetail.setQuantity(orderDetailEntity.getQuantity());
        orderDetail.setProduct(productEntityConverter.convert(orderDetailEntity.getProduct()));
    }

    @Override
    public OrderDetail createFromClass() {
        return new OrderDetail();
    }
}
