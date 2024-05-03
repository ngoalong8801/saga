package com.pm.inventory.event;

import com.pm.common.config.KafkaConsumerConfig;
import com.pm.common.constant.EventType;
import com.pm.common.converters.Converter;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.event.ProductRecord;
import com.pm.common.dto.response.Order;
import com.pm.common.event.AbstractEventListener;
import com.pm.common.event.executors.PlatformExecutorService;
import com.pm.common.model.OrderR;
import com.pm.common.model.ProductR;
import com.pm.common.repository.OrderRRepository;
import com.pm.inventory.entity.ProductEntity;
import com.pm.inventory.event.executors.OrderCreationExecutorService;
import com.pm.inventory.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Component
@Getter
public class OrderCreationListener extends AbstractEventListener<OrderRecord> {
    public static final String ORDER_CREATED_TOPIC = EventType.ORDER_CREATED_EVENT.toString();
    public static final String ROLLBACK_TOPIC = EventType.ORDER_CREATED_RB_EVENT.toString();

    @Autowired
    OrderRRepository orderRRepository;
    @Autowired
    Converter<ProductRecord, ProductR> productRecord2ProductRConverter;

    @Autowired
    ProductService productService;

    @Autowired
    Converter<ProductEntity, ProductR> productEntity2ProductRConverter;
    @Autowired
    PlatformExecutorService<Object, OrderRecord> orderCreationExecutorService;

    @Override
    @KafkaListener(
            topics = "#{T(com.pm.inventory.event.OrderCreationListener).ORDER_CREATED_TOPIC}",
            groupId = "inventory",
            containerFactory = KafkaConsumerConfig.KAFKA_CONSUMER_CONFIG_CONTAINER_FACTORY_OBJ)
    public void onListen(Event<OrderRecord> event) throws IOException, ExecutionException, InterruptedException {
        super.onListen(event);
        getOrderCreationExecutorService().populateEvent(event);
        getOrderCreationExecutorService().executeAll();
    }

    @Override
    @KafkaListener(
            topics = "#{T(com.pm.inventory.event.OrderCreationListener).ROLLBACK_TOPIC}",
            groupId = "foo",
            containerFactory = KafkaConsumerConfig.KAFKA_CONSUMER_CONFIG_CONTAINER_FACTORY_OBJ)
    public void rollback(Event<OrderRecord> event) {

    }
}
