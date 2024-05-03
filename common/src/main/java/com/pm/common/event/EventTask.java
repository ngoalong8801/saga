package com.pm.common.event;

import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderRecord;
import lombok.Getter;

import java.util.concurrent.Callable;

@Getter
public abstract class EventTask<T, R> implements Callable<T> {
    private Event<R> event;

    public void setEvent(Event<R> event) {
        this.event = event;
    }
}
