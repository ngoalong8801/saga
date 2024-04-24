package com.pm.common.dto.event;

import com.pm.common.status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event<T> {
    Status status;
    T data;
}
