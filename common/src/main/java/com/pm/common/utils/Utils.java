package com.pm.common.utils;

import com.pm.common.dto.response.Response;
import com.pm.common.status.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Utils<T> {
    public Response<T> generateResponse(Message message, List<T> results) {
        return new Response<>(message, results);
    }

    public Response<T> generateSuccessResponse(List<T> results) {
        return generateResponse(Message.SUCCESS, results);
    }
    public Response<T> generateSuccessResponse() {
        return generateResponse(Message.SUCCESS, null);
    }

    public Response<T> generateFailedResponse(List<T> results) {
        return generateResponse(Message.FAILED, results);
    }
    public Response<T> generateFailedResponse() {
        return generateResponse(Message.FAILED, null);
    }

}
