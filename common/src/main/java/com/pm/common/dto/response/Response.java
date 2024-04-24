package com.pm.common.dto.response;

import com.pm.common.status.Name;
import com.pm.common.status.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Response<T> {
    Status status;
    String message;
    List<T> results;
}
