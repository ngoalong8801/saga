package com.pm.common.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.Record;

import java.io.IOException;

public interface EventListener<T extends Record> {
    void onListen(Event<T> event) throws IOException;
    void rollback(Event<T> event);
}
