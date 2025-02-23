package com.transport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseBusInfo {
    @JsonProperty("ServiceNo")
    private String serviceNo;

    @JsonProperty("Operator")
    private String operator;
}
