package com.example.trangg.model;

public class OrderItem {
    private String productId;
    private int quantity;
    private double totalPrice;


    public OrderItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = 0; // Default to 0, to be calculated later
    }

    public OrderItem(String productId, int quantity, double totalPrice) {
        this.productId = productId;
        setQuantity(quantity);
        setTotalPrice(totalPrice);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        if (totalPrice < 0) {
            throw new IllegalArgumentException("Total price cannot be negative.");
        }
        this.totalPrice = totalPrice;
    }

    public void calculateTotalPrice(double productPrice) {
        if (productPrice < 0) {
            throw new IllegalArgumentException("Product price cannot be negative.");
        }
        this.totalPrice = productPrice * this.quantity;
    }

    @Override
    public String toString() {
        return String.format("Product ID: %s, Quantity: %d, Total Price: %.2f",
                productId, quantity, totalPrice);
    }
}
