package com.transport.model.bus.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BusServiceInfoResp {
    @JsonProperty("odata.metadata")
    private String metadata;
    private List<BusServiceInfo> value;
}
