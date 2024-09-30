package com.example.trangg.model;

public class Product {
    private String productId;
    private String name;
    private double price;
    private int stock;


    public Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        setPrice(price);
        setStock(stock);
    }


    public Product(String productId, String name, double price) {
        this(productId, name, price, 0); // Calls the primary constructor with stock set to 0
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        this.stock = stock;
    }


    public void increaseStock(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Increase amount cannot be negative.");
        }
        this.stock += amount;
    }

    public void decreaseStock(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Decrease amount cannot be negative.");
        }
        if (this.stock - amount < 0) {
            throw new IllegalArgumentException("Insufficient stock to decrease.");
        }
        this.stock -= amount;
    }

    @Override
    public String toString() {
        return String.format("Product ID: %s, Name: %s, Price: %.2f, Stock: %d",
                productId, name, price, stock);
    }
}
