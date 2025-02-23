package com.transport.model.bus.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transport.model.BaseBusInfo;

public class BusServiceInfo extends BaseBusInfo {
    @JsonProperty("Direction")
    private String direction;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("OriginCode")
    private String originCode;
    @JsonProperty("DestinationCode")
    private String destinationCode;
    @JsonProperty("AM_Peak_Freq")
    private String amPeakFreq;
    @JsonProperty("AM_Offpeak_Freq")
    private String amOffPeakFreq;
    @JsonProperty("PM_Peak_Freq")
    private String pmPeakFreq;
    @JsonProperty("PM_Offpeak_Freq")
    private String pmOffPeakFreq;
    @JsonProperty("LoopDesc")
    private String loopDesc;


}
