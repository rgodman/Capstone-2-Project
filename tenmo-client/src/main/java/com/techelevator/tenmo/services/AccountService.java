package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import org.apiguardian.api.API;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public class AccountService {

    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();

    public AccountService(String apiURL) {
        API_BASE_URL = apiURL;

    }

    //is this getting the account info? it looks like it is getting a Balance?
    public Account getAccount(AuthenticatedUser currentUser) {
        Account account = null;
        return restTemplate.exchange(API_BASE_URL + "balance/" + currentUser.getUser().getId(), HttpMethod.GET, makeAuthEntity(currentUser), Account.class).getBody();
    }

    //This said just update, but what does it update? the account name, user name, etc are all things that can be
    // updated, it looks like it updates the balance, so i made the naming more clear to "updateBalance"
    public Account updateBalance(BigDecimal amount, Long userId) throws AccountServiceException {
        Account account = new Account();
        try {
            restTemplate.put(API_BASE_URL + "balance/" + userId + "?amount=" + amount, HttpMethod.PUT, makeAccountEntity(account), Account.class);
        } catch (RestClientResponseException ex) {
            throw new AccountServiceException(ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString());
        }
        return account;
    }

    private HttpEntity makeAuthEntity(AuthenticatedUser currentUser) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }

    private HttpEntity makeAccountEntity(Account account) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(null);
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }

}