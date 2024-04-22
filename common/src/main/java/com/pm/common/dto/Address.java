package com.pm.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + postalCode;
    }
}
