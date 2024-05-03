package com.pm.common.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.Record;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface EventListener<T extends Record> {
    void onListen(Event<T> event) throws IOException, ExecutionException, InterruptedException;
    void rollback(Event<T> event);
}
