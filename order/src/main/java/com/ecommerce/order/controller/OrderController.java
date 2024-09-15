package com.ecommerce.order.controller;

import com.ecommerce.order.dtos.OrderRecordDto;
import com.ecommerce.order.models.OrderDetailModel;
import com.ecommerce.order.models.OrderModel;
import com.ecommerce.order.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderModel> saveOrder(@RequestBody OrderRecordDto orderRecordDto) {
        var orderModel = new OrderModel();
        BeanUtils.copyProperties(orderRecordDto, orderModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orderModel));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderModel>> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderDetailModel> getOrderById(@PathVariable UUID orderId) {
        if (orderId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        OrderDetailModel orderDetailModel = orderService.findById(orderId);
        if (orderDetailModel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(orderDetailModel);
    }
}
