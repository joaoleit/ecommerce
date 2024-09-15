package com.ecommerce.order.models;

public class OrderDetailModel {
    private OrderModel order;
    private UserModel user;

    public OrderDetailModel(OrderModel order, UserModel user) {
        this.order = order;
        this.user = user;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

}
