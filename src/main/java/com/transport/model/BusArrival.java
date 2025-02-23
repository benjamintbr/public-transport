package com.transport.model;

import lombok.Data;

@Data
public class BusArrival {
    private String serviceNo;
    private String operator;
    private NextBus nextFirstBus;
    private NextBus nextSecondBus;
    private NextBus nextThirdBus;
}
