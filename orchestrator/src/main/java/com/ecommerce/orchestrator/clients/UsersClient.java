package com.ecommerce.orchestrator.clients;

import com.ecommerce.orchestrator.models.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name="user-service", url = "http://gateway-service:8080")
public interface UsersClient {

    @GetMapping("/users/{userId}")
    UserModel getUser(@PathVariable("userId") UUID userId);
}
