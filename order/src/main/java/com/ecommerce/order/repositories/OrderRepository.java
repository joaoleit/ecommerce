package com.ecommerce.order.repositories;

import com.ecommerce.order.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderModel, UUID> {
    OrderModel findOrderModelById(UUID id);
}
