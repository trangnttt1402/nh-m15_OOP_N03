package com.example.trangg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private String orderId;
    private List<Product> products;


    public Order(String orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
    }

    // Overloaded constructor with only orderId
    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Object getOrderId() {
        return null;
    }

    // Getters and setters
}
