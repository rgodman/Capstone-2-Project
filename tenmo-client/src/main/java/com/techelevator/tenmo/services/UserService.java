package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;
import org.springframework.web.client.RestTemplate;

public class UserService {

    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();

    public UserService(String apiURL) {
        API_BASE_URL = apiURL;

    }

   // public User findAll()
}
