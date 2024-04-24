package com.pm.order.event;

import com.pm.common.config.KafkaConsumerConfig;
import com.pm.common.constant.EventType;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderCreatedEvent;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.event.Record;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrderCreatedListener implements EventListener<OrderRecord> {
    public static final String topic = EventType.ORDER_CREATED_EVENT.toString();

    @Override
    @KafkaListener(
            topics = "#{T(com.pm.order.event.OrderCreatedListener).topic}",
            groupId = "foo",
            containerFactory = KafkaConsumerConfig.KAFKA_CONSUMER_CONFIG_CONTAINER_FACTORY_OBJ)
    public void onListen(Event<OrderRecord> event) {
        System.out.println(event);
    }
}
