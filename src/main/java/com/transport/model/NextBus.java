package com.transport.model;

import lombok.Data;

@Data
public class NextBus {
    private String estimatedArrival;
    private String latitude;
    private String longitude;
}
