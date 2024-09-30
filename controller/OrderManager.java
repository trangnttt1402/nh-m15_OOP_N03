package com.example.trangg.controller;

import com.example.trangg.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void updateOrder(Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId().equals(updatedOrder.getOrderId())) {
                orders.set(i, updatedOrder);
                break;
            }
        }
    }

    public void deleteOrder(String orderId) {
        orders.removeIf(order -> order.getOrderId().equals(orderId));
    }

    public List<Order> getOrders() {
        return orders;
    }
}
