package com.pm.inventory.event.task;

import com.pm.common.converters.Converter;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.event.ProductRecord;
import com.pm.common.dto.response.Order;
import com.pm.common.event.EventTask;
import com.pm.common.model.OrderR;
import com.pm.common.model.ProductR;
import com.pm.common.repository.OrderRRepository;
import com.pm.inventory.entity.ProductEntity;
import com.pm.inventory.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.concurrent.Callable;
@Component
public class UpdateInventoryReadModelTask extends EventTask<Object, OrderRecord> {

    @Autowired
    OrderRRepository orderRRepository;
    @Autowired
    Converter<ProductRecord, ProductR> productRecord2ProductRConverter;

    @Autowired
    ProductService productService;

    @Autowired
    Converter<ProductEntity, ProductR> productEntity2ProductRConverter;
    @Override
    public Object call() throws Exception {
        OrderRecord orderRecord = getEvent().getRecord();
        List<ProductR> updatedProductRs = updatedProductModels(orderRecord);
        updateOrderRecord(orderRecord, updatedProductRs);
        return new Object();
    }

    private List<ProductR> updatedProductModels(OrderRecord orderRecord) {
        List<ProductR> productRs = productRecord2ProductRConverter.convertAll(orderRecord.getItems());
        List<ProductEntity> productEntities = productService.findProductByIds(orderRecord);
        productRs = productEntity2ProductRConverter.convertAll(productEntities, productRs);
        return productRs;
    }

    private void updateOrderRecord(OrderRecord orderRecord, List<ProductR> productRS) {
       orderRRepository.findById(orderRecord.getId()).
               ifPresent(
                       orderR -> {
                           orderR.setItems(new HashSet<>(productRS));
                           orderRRepository.save(orderR);
                       }
               );
    }
}
