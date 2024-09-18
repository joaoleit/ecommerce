package com.ecommerce.payment.controllers;

import com.ecommerce.payment.dtos.PaymentRecordDto;
import com.ecommerce.payment.models.PaymentModel;
import com.ecommerce.payment.services.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentModel> makePayment(@RequestBody @Valid PaymentRecordDto paymentRecordDto) {
        var result = paymentService.makeRequest();
        var payment = new PaymentModel(paymentRecordDto.orderId(), paymentRecordDto.amount(), result);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }
}
