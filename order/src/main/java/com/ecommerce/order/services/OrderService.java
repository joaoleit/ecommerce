package com.ecommerce.order.services;

import com.ecommerce.order.models.OrderDetailModel;
import com.ecommerce.order.models.OrderModel;
import com.ecommerce.order.models.UserModel;
import com.ecommerce.order.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    final OrderRepository orderRepository;
    final UserService userService;

    public OrderService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public OrderModel save(OrderModel orderModel) {
        return orderRepository.save(orderModel);
    }

    public List<OrderModel> findAll() {
        return orderRepository.findAll();
    }

    public OrderDetailModel findById(UUID id) {
        Optional<OrderModel> order = orderRepository.findById(id);
        if (order.isEmpty()) return null;
        UUID userId = order.get().getUserId();
        UserModel user = userService.getUserById(userId);
        return new OrderDetailModel(order.get(), user);
    }
}
