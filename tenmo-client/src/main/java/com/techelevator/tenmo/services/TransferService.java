package com.techelevator.tenmo.services;

import org.springframework.web.client.RestTemplate;

public class TransferService {

    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();

    public TransferService(String apiURL) {
        API_BASE_URL = apiURL;

    }
}