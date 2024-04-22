package com.pm.common.dto.response;

import com.pm.common.status.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Response<T> {
    Message message;
    List<T> results;
}
