package com.transport.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.transport.model.bus.route.BusRouteInfo;
import com.transport.model.bus.service.BusServiceInfo;
import com.transport.service.BusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus")
@Slf4j
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/nextBus")
    public ResponseEntity<Object> nextBus(@RequestParam String busStopCode) {
        try {
            JsonNode response = busService.getBusArrivalInfo(busStopCode);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error occurred while retrieving next bus info.";
            log.error(errorMsg, e);
            return new ResponseEntity<>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBusInfo")
    public ResponseEntity<Object> getBusInfo(@RequestParam String busNumber) {
        try {
            BusServiceInfo response = busService.getBusServiceInfo(busNumber);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error occurred while retrieving bus service info for " + busNumber + ".";
            log.error(errorMsg, e);
            return new ResponseEntity<>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBusRoute")
    public ResponseEntity<Object> getBusRoute(@RequestParam String busNumber) {
        try {
            BusRouteInfo response = busService.getBusRouteInfo(busNumber);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error occurred while retrieving bus route info for " + busNumber + ".";
            log.error(errorMsg, e);
            return new ResponseEntity<>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
