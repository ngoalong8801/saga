package com.pm.common.status;

import lombok.Getter;

@Getter
public enum Code {
    SUCCESS(200),
    ERROR(404);
    // Method to retrieve the code
    private final int code;
    Code(int code) {
        this.code = code;
    }

}
