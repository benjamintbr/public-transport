package com.transport.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class BusService {

    @Autowired
    private DataMallService dataMallService;

    @Value("${datamall.bus.arrival-url}")
    private String busArrivalUrl;

    public JsonNode getBusArrivalInfo(String busStopCode) throws JsonProcessingException {
        busArrivalUrl = UriComponentsBuilder.fromUriString(busArrivalUrl)
                .queryParam("BusStopCode", busStopCode)
                .toUriString();
        String response = dataMallService.callDataMallAPI(busArrivalUrl, HttpMethod.GET);
        log.info("Response received : {}", response);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(response);
    }
}
