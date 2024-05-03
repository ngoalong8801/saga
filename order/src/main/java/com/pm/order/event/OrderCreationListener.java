package com.pm.order.event;

import com.pm.common.config.KafkaConsumerConfig;
import com.pm.common.constant.EventType;
import com.pm.common.converters.Converter;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.event.AbstractEventListener;
import com.pm.common.model.OrderR;
import com.pm.common.repository.OrderRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OrderCreationListener extends AbstractEventListener<OrderRecord> {
    public static final String ORDER_CREATED_TOPIC = EventType.ORDER_CREATED_EVENT.toString();
    public static final String ROLLBACK_TOPIC = EventType.ORDER_CREATED_RB_EVENT.toString();

    @Autowired
    OrderRRepository orderRRepository;
    @Autowired
    Converter<OrderRecord, OrderR> orderRecord2OrderRConverter;

    @Override
    @KafkaListener(
            topics = "#{T(com.pm.order.event.OrderCreationListener).ORDER_CREATED_TOPIC}",
            groupId = "foo",
            containerFactory = KafkaConsumerConfig.KAFKA_CONSUMER_CONFIG_CONTAINER_FACTORY_OBJ)
    public void onListen(Event<OrderRecord> event) throws IOException {
//        OrderRecord orderRecord = makeRecord(event, OrderRecord.class);
//        OrderR orderR = orderRecord2OrderRConverter.convert(orderRecord);
//        orderRRepository.save(orderR);
    }

    @Override
    @KafkaListener(
            topics = "#{T(com.pm.order.event.OrderCreationListener).ROLLBACK_TOPIC}",
            groupId = "foo",
            containerFactory = KafkaConsumerConfig.KAFKA_CONSUMER_CONFIG_CONTAINER_FACTORY_OBJ)
    public void rollback(Event<OrderRecord> event) {
    }
}
