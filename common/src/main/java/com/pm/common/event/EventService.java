package com.pm.common.event;

import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.Record;

public interface EventService {
    <T extends Record> void publishEvent(Event<T> event);
}
