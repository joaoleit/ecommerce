package com.ecommerce.orchestrator.controllers;

import com.ecommerce.orchestrator.dtos.OrderRecordDto;
import com.ecommerce.orchestrator.models.OrderModel;
import com.ecommerce.orchestrator.services.OrchestrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrchestrationController {
    private final OrchestrationService orchestrationService;

    public OrchestrationController(final OrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderModel> createOrder(@RequestBody OrderRecordDto orderRecordDto) {
        var order = orchestrationService.createOrder(orderRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
