package com.ecommerce.order.models;

import java.util.List;
import java.util.UUID;

public class OrderDetailModel {
    private UUID id;
    private UUID userId;
    private String name;
    private String email;
    private List<String> items;
    private String status;

    public OrderDetailModel(OrderModel order, UserModel user) {
        this.id = order.getId();
        this.userId = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.items = order.getItems();
        this.status = order.getStatus();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
