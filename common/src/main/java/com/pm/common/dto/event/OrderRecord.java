package com.pm.common.dto.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

@Data
public class OrderRecord implements Record {
    int id;
    private String customerEmail;
    List<ProductRecord> items;
    String paymentMethod;
}
