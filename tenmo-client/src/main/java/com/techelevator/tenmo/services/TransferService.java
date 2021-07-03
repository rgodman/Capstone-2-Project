package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TransferService {

    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();

    public TransferService(String apiURL) {
        API_BASE_URL = apiURL;

    }

    public Transfer listTransfers (AuthenticatedUser currentUser) {
    Transfer transfer = null;
    return restTemplate.exchange(API_BASE_URL + "transfers/" + currentUser.getUser().getId(), HttpMethod.GET, makeAuthEntity(currentUser), Transfer.class).getBody();

    }

    public void sendBucks(AuthenticatedUser currentUser, Long accountFrom, Long accountTo, BigDecimal amount) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Transfer transfer = new Transfer();


    }

    private HttpEntity makeAuthEntity(AuthenticatedUser currentUser) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }

    private HttpEntity makeTransAuthEntity(AuthenticatedUser currentUser, BigDecimal amount) {
        Transfer moneyTransfer = new Transfer();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity entity = new HttpEntity(moneyTransfer, headers);
        return entity;
    }
}
