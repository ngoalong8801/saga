package com.pm.common.dto.event;

import com.pm.common.status.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Event <T extends Record> {
    Status status;
    String type;
    T record;
    public Event() {
    }
}
