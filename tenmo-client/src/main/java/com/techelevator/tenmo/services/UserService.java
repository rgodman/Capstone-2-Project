package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class UserService {

    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();

    public UserService(String apiURL) {
        API_BASE_URL = apiURL;

    }

   public User[] findAll(AuthenticatedUser currentUser) {
    User[] user = null;
    try {
        user = restTemplate.exchange(API_BASE_URL + "users/", HttpMethod.GET, makeAuthEntity(currentUser), User[].class).getBody();
    } catch (RestClientResponseException ex) {
        throw new ResourceAccessException(ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString());
    } return user;
   }

    private HttpEntity makeAuthEntity(AuthenticatedUser currentUser) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }
}
