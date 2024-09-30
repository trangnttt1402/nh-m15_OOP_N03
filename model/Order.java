package com.example.trangg.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private List<OrderItem> items;
    private double totalAmount;

    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>(); // Initialize with an empty ArrayList
        this.totalAmount = 0; // Initialize total amount as 0
    }

    public Order(String orderId, List<OrderItem> items) {
        this.orderId = orderId;
        this.items = new ArrayList<>(items); // Copy items to avoid external modification
        calculateTotalAmount(); // Calculate total amount based on the items
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
        calculateTotalAmount(); // Recalculate total amount when items are set
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount < 0) {
            throw new IllegalArgumentException("Total amount cannot be negative.");
        }
        this.totalAmount = totalAmount;
    }


    public void addItem(OrderItem item) {
        if (item != null) {
            items.add(item);

            calculateTotalAmount();
        }
    }


    public void calculateTotalAmount() {
        totalAmount = items.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Items:\n");
        for (OrderItem item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total Amount: ").append(String.format("%.2f", totalAmount));
        return sb.toString();
    }
}
