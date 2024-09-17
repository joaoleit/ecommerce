package com.ecommerce.payment.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "external-service", url = "http://django:8000")
public interface ExternalClient {

    @PostMapping("/payment/")
    String postPayment();
}
