package com.pm.common.dto.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class ProductRecord implements Record {
    private int id;
    private int quantity;
}
