package com.ecommerce.orchestrator.clients;

import com.ecommerce.orchestrator.dtos.PaymentRecordDto;
import com.ecommerce.orchestrator.models.PaymentModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "http://gateway-service:8080")
public interface PaymentClient {

    @PostMapping("/payment")
    PaymentModel makePayment(@RequestBody PaymentRecordDto paymentRecordDto);
}
