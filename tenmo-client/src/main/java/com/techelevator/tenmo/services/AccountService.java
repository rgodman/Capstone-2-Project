package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class AccountService {

    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();

    public AccountService(String apiURL) {
        API_BASE_URL = apiURL;

    }

    public Account getAccount(AuthenticatedUser currentUser) {
        Account account = null;
        return restTemplate.exchange(API_BASE_URL + "balance/" + currentUser.getUser().getId(), HttpMethod.GET, makeAuthEntity(currentUser), Account.class).getBody();
    }

    private HttpEntity makeAuthEntity(AuthenticatedUser currentUser) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }
}
