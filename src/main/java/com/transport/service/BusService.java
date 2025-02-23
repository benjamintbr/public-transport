package com.transport.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transport.exception.NotFoundException;
import com.transport.model.bus.route.BusRouteInfo;
import com.transport.model.bus.route.BusRouteInfoResp;
import com.transport.model.bus.service.BusServiceInfo;
import com.transport.model.bus.service.BusServiceInfoResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
@Slf4j
public class BusService {

    @Autowired
    private DataMallService dataMallService;

    @Value("${datamall.bus.arrival-url}")
    private String busArrivalUrl;
    @Value("${datamall.bus.all-bus-info-url}")
    private String allBusInfoUrl;
    @Value("${datamall.bus.bus-route-info-url}")
    private String busRouteInfoUrl;


    public JsonNode getBusArrivalInfo(String busStopCode) throws JsonProcessingException {
        busArrivalUrl = UriComponentsBuilder.fromUriString(busArrivalUrl)
                .queryParam("BusStopCode", busStopCode)
                .toUriString();
        String response = dataMallService.callDataMallAPI(busArrivalUrl, HttpMethod.GET);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(response);
    }

    public BusServiceInfo getBusServiceInfo(String busNumber) throws JsonProcessingException {
        String rawResp = dataMallService.callDataMallAPI(allBusInfoUrl, HttpMethod.GET);
        ObjectMapper mapper = new ObjectMapper();
        BusServiceInfoResp resp = mapper.readValue(rawResp, BusServiceInfoResp.class);

        Optional<BusServiceInfo> service = resp.getValue().stream()
                .filter(bus -> bus.getServiceNo().equals(busNumber))
                .findFirst();

        if (service.isEmpty())
            throw new NotFoundException("Bus service " + busNumber + " not found.");

        return service.get();
    }

    public BusRouteInfo getBusRouteInfo(String busNumber) throws JsonProcessingException {
        String rawResp = dataMallService.callDataMallAPI(busRouteInfoUrl, HttpMethod.GET);
        ObjectMapper mapper = new ObjectMapper();
        BusRouteInfoResp resp = mapper.readValue(rawResp, BusRouteInfoResp.class);

        Optional<BusRouteInfo> service = resp.getValue().stream()
                .filter(bus -> bus.getServiceNo().equals(busNumber))
                .findFirst();

        if (service.isEmpty())
            throw new NotFoundException("Bus service " + busNumber + " not found.");

        return service.get();
    }
}
