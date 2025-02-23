package com.transport.model.bus.route;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BusRouteInfoResp {
    @JsonProperty("odata.metadata")
    private String metadata;
    private List<BusRouteInfo> value;
}
