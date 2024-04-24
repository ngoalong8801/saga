package com.pm.order.converter;

import com.pm.common.converters.AbstractConverter;
import com.pm.order.entity.OrderDetailEntity;
import com.pm.order.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MapProductQuantityConverter extends AbstractConverter<Map.Entry<ProductEntity, Integer>, OrderDetailEntity> {
    @Override
    public void populate(Map.Entry<ProductEntity, Integer> productEntityIntegerEntry, OrderDetailEntity orderDetailEntity) {
        ProductEntity entity = productEntityIntegerEntry.getKey();
        int quantity = productEntityIntegerEntry.getValue();
        orderDetailEntity.setCurPrice(entity.getPrice());
        orderDetailEntity.setQuantity(quantity);
        orderDetailEntity.setProduct(entity);
    }

    @Override
    public OrderDetailEntity createFromClass() {
        return new OrderDetailEntity();
    }
}
