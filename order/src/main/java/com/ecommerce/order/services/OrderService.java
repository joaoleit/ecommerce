package com.ecommerce.order.services;

import com.ecommerce.order.models.OrderModel;
import com.ecommerce.order.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderModel save(OrderModel orderModel) {
        return orderRepository.save(orderModel);
    }
}
