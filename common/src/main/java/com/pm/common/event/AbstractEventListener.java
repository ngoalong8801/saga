package com.pm.common.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.event.Record;

import java.io.IOException;

public abstract class AbstractEventListener<T extends Record> implements EventListener<T> {
    ObjectMapper objectMapper;
    {
        objectMapper = new ObjectMapper();
    }
    public T makeRecord(Event<T> event, Class<T> clazz) throws IOException {
        var dataJson = objectMapper.writeValueAsBytes(event.getRecord());
        return objectMapper.readValue(dataJson , clazz);
    }
}
