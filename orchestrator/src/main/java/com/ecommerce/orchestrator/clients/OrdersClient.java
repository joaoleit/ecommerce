package com.ecommerce.orchestrator.clients;

import com.ecommerce.orchestrator.dtos.OrderRecordDto;
import com.ecommerce.orchestrator.dtos.OrderStatusDto;
import com.ecommerce.orchestrator.models.OrderModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "order-service", url = "http://gateway-service:8080")
public interface OrdersClient {

    @PostMapping("/orders")
    OrderModel createOrder(@RequestBody OrderRecordDto orderRecordDto);

    @PutMapping("/orders/{orderId}/status")
    void updateOrderStatus(@PathVariable("orderId") UUID orderId, @RequestBody OrderStatusDto orderStatusDto);
}
