package com.ecommerce.payment.models;

import java.util.UUID;

public class PaymentModel {
    private UUID orderId;
    private Double amount;
    private String status;

    public PaymentModel(UUID orderId, Double amount, String status) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
