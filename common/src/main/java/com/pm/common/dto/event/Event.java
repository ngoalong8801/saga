package com.pm.common.dto.event;

import com.pm.common.constant.EventType;
import com.pm.common.status.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event <T> {
    EventType eventType;
    T record;
    public Event() {
    }
    public static class Builder<T> {
        private EventType eventType;
        private T record;

        public Builder() {
        }

        public Builder<T> eventType(EventType eventType) {
            this.eventType = eventType;
            return this;
        }


        public Builder<T> record(T record) {
            this.record = record;
            return this;
        }

        public Event<T> build() {
            Event<T> event = new Event<T>(this.eventType, this.record);
            return event;
        }
    }
}
