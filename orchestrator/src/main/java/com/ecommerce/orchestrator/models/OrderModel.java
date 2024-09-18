package com.ecommerce.orchestrator.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderModel {
    private UUID id;
    private UUID userId;
    private List<String> items = new ArrayList<>();
    private String status;

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
