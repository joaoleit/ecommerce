package com.ecommerce.orchestrator.services;

import com.ecommerce.orchestrator.clients.OrdersClient;
import com.ecommerce.orchestrator.clients.PaymentClient;
import com.ecommerce.orchestrator.clients.UsersClient;
import com.ecommerce.orchestrator.dtos.OrderRecordDto;
import com.ecommerce.orchestrator.dtos.OrderStatusDto;
import com.ecommerce.orchestrator.dtos.PaymentRecordDto;
import com.ecommerce.orchestrator.models.OrderModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrchestrationService {
    private final OrdersClient ordersClient;
    private final UsersClient usersClient;
    private final PaymentClient paymentClient;

    public OrchestrationService(OrdersClient ordersClient, UsersClient usersClient, PaymentClient paymentClient) {
        this.ordersClient = ordersClient;
        this.usersClient = usersClient;
        this.paymentClient = paymentClient;
    }

    public OrderModel createOrder(OrderRecordDto orderRecordDto) {
        // Check if userId is valid
        var userModel = usersClient.getUser(orderRecordDto.userId());
        if (userModel == null) {
            return null;
        }

        var orderModel = ordersClient.createOrder(orderRecordDto);
        var orderId = orderModel.getId();

        var paymentRecord = new PaymentRecordDto(orderId, calculateAmount(orderModel.getItems()), "credit");
        var payment = paymentClient.makePayment(paymentRecord);

        var orderStatus = new OrderStatusDto(payment.getStatus());
        ordersClient.updateOrderStatus(orderId, orderStatus);

        return orderModel;
    }

    private Double calculateAmount(List<String> items) {
        return (double) (items.size() * 10);
    }
}
