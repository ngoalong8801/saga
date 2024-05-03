package com.pm.inventory.event.executors;

import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.response.Order;
import com.pm.common.event.EventTask;
import com.pm.common.event.executors.DefaultExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderCreationExecutorService extends DefaultExecutorService<Object, OrderRecord> {
    @Autowired
    public void setEventTasks(List<EventTask<Object, OrderRecord>> eventTasks) {
        super.setEventTasks(eventTasks);
    }
}
