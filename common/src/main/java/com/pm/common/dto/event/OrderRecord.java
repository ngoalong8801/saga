package com.pm.common.dto.event;

import lombok.Data;
import org.springframework.context.ApplicationEventPublisher;

@Data
public class OrderRecord implements Record {
    int id;
    private String customerEmail;
    private int total;
}
