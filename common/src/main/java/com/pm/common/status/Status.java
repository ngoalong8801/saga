package com.pm.common.status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Status {
    Code code;
    Name name;
}
