package com.transport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class DataMallService {

    private final RestTemplate restTemplate;
    @Autowired
    public DataMallService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${datamall.acc-key}")
    private String accKey;

    private static final String ACCOUNT_KEY = "AccountKey";

    public String callDataMallAPI(String url, HttpMethod method) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCOUNT_KEY, accKey);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, method, entity, String.class);

        return response.getBody();
    }
}
