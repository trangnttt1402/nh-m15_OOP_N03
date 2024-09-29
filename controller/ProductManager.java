package com.example.trangg.controller;

import com.example.trangg.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
