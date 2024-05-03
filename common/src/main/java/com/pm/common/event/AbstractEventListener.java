package com.pm.common.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.event.Record;
import com.pm.common.event.executors.PlatformExecutorService;
import org.springframework.core.ResolvableType;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public abstract class AbstractEventListener<T extends Record> implements EventListener<T> {
    private Class<T> typeParameterClass;

    ObjectMapper objectMapper;
    {
        objectMapper = new ObjectMapper();
    }

    public AbstractEventListener() {
        this.objectMapper = new ObjectMapper();
        // Extract generic type at runtime
        this.typeParameterClass = (Class<T>) ResolvableType.forClass(AbstractEventListener.class, getClass()).resolveGeneric(0);
    }

    @Override
    public void onListen(Event<T> event) throws IOException, ExecutionException, InterruptedException {
        T record = makeRecord(event);
        event.setRecord(record);
    }

    public T makeRecord(Event<T> event) throws IOException {
        var dataJson = objectMapper.writeValueAsBytes(event.getRecord());
        return objectMapper.readValue(dataJson , typeParameterClass);
    }
}
