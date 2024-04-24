package com.pm.order.event;

import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.Record;

public interface EventListener<T extends Record> {
    void onListen(Event<T> event);
}
