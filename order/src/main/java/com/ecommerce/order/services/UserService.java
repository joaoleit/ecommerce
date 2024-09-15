package com.ecommerce.order.services;

import com.ecommerce.order.models.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserModel getUserById(UUID id) {
        return restTemplate.getForObject("http://localhost:8080/users/" + id, UserModel.class);
    }
}
