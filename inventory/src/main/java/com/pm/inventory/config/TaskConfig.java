package com.pm.inventory.config;

import com.pm.common.dto.event.OrderRecord;
import com.pm.common.event.EventTask;
import com.pm.inventory.event.task.DeductInventoryTask;
import com.pm.inventory.event.task.UpdateInventoryReadModelTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    List<EventTask<Object, OrderRecord>> orderCreationTasks(DeductInventoryTask deductInventoryTask, UpdateInventoryReadModelTask updateInventoryReadModelTask)
    {
        return Arrays.asList(deductInventoryTask, updateInventoryReadModelTask);
    }
}
