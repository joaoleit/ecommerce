package com.ecommerce.payment.services;

import com.ecommerce.payment.clients.ExternalClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final ExternalClient externalClient;

    public PaymentService(ExternalClient externalClient) {
        this.externalClient = externalClient;
    }

    public String makeRequest() {
        var res = externalClient.postPayment();
        return res.replaceAll("\"", "");
    }
}
