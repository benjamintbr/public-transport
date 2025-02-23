package com.transport.model.bus.route;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transport.model.BaseBusInfo;

public class BusRouteInfo extends BaseBusInfo {
    @JsonProperty("Direction")
    private String direction;
    @JsonProperty("StopSequence")
    private int stopSequence;
    @JsonProperty("BusStopCode")
    private String busStopCode;
    @JsonProperty("Distance")
    private double distance;
    @JsonProperty("WD_FirstBus")
    private String wdFirstBus;
    @JsonProperty("WD_LastBus")
    private String wdLastBus;
    @JsonProperty("SAT_FirstBus")
    private String satFirstBus;
    @JsonProperty("SAT_LastBus")
    private String satLastBus;
    @JsonProperty("SUN_FirstBus")
    private String sunFirstBus;
    @JsonProperty("SUN_LastBus")
    private String sunLastBus;
}
