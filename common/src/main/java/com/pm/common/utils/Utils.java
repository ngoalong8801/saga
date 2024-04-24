package com.pm.common.utils;

import com.pm.common.dto.response.Response;
import com.pm.common.status.Code;
import com.pm.common.status.Name;
import com.pm.common.status.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class Utils<T> {
    public Response<T> generateResponse(Status status, String message , List<T> results) {
        return Response.<T>builder()
                .message(message)
                .status(status)
                .results(results)
                .build();
    }

    public Response<T> generateSuccessResponse(List<T> results) {
        return generateResponse(generateSuccessStatus(), "", results);
    }
    public Response<T> generateSuccessResponse(T result) {
        return generateResponse(generateSuccessStatus(), "", Collections.singletonList(result));
    }
    public Response<T> generateSuccessResponse() {
        return generateResponse(generateSuccessStatus(), "", null);
    }

    public ResponseEntity<Response<T>> generateFailedResponse(List<T> results) {
        return ResponseEntity
                .status(404)
                .body(generateResponse(generateFailedStatus(), "", results));
    }
    public ResponseEntity<Response<T>> generateFailedResponse() {
        return ResponseEntity
                .status(404)
                .body(generateResponse(generateFailedStatus(), "", null));
    }

    public Response<T> generateSuccessResponse(String message ,List<T> results) {
        return generateResponse(generateSuccessStatus(), message, results);
    }
    public Response<T> generateSuccessResponse(String message) {
        return generateResponse(generateSuccessStatus(), message, null);
    }

    public ResponseEntity<Response<T>> generateFailedResponse(String message, List<T> results) {
        return ResponseEntity
                .status(404)
                .body(generateResponse(generateFailedStatus(), message, results));
    }
    public ResponseEntity<Response<T>> generateFailedResponse(String message) {
        return ResponseEntity
                .status(404)
                .body(generateResponse(generateFailedStatus(), message, null));
    }

    public Status generateFailedStatus() {
        return new Status(Code.ERROR, Name.FAILED);
    }

    public Status generateSuccessStatus() {
        return new Status(Code.SUCCESS, Name.SUCCESS);
    }
}
