package com.pm.common.dto.event;

import com.pm.common.constant.EventType;
import com.pm.common.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreatedEvent extends Event<OrderRecord> {
    public OrderCreatedEvent() {
        super();
        this.type = EventType.ORDER_CREATED_EVENT.toString();
    }
    public OrderCreatedEvent(OrderRecord record) {
        super();
        this.type = EventType.ORDER_CREATED_EVENT.toString();
        this.record = record;
    }
}
