package com.pm.inventory.event.task;


import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.event.EventTask;
import com.pm.common.model.OrderR;
import com.pm.inventory.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.Callable;

@Component
public class DeductInventoryTask extends EventTask<Object, OrderRecord> {

    @Autowired
    ProductService productService;
    @Override
    public Object call() throws Exception {
        productService.deductQuantityOfProduct(getEvent().getRecord());
        return new Object();
    }
}
