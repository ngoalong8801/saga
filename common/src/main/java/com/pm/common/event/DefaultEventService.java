package com.pm.common.event;

import com.pm.common.config.KafkaProducerConfig;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DefaultEventService implements EventService {
    @Autowired
    @Qualifier(KafkaProducerConfig.KAFKA_PRODUCER_CONFIG_TEMPLATE_OBJ)
    private KafkaTemplate<String, Object> kafkaTemplate;
    @Override
    public <T extends Record> void publishEvent(Event<T> event) {
        kafkaTemplate.send(event.getEventType().name(), event);
    }
}
