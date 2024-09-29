package com.example.trangg.view;

import com.example.trangg.controller.ProductManager;
import com.example.trangg.model.Product;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductWindow {
    public static void display(ProductManager productManager) {
        Stage window = new Stage();
        window.setTitle("Quản lý sản phẩm");

        TextField idField = new TextField();
        idField.setPromptText("Mã sản phẩm");
        TextField nameField = new TextField();
        nameField.setPromptText("Tên sản phẩm");
        TextField priceField = new TextField();
        priceField.setPromptText("Giá sản phẩm");

        Button addButton = new Button("Thêm sản phẩm");
        addButton.setOnAction(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            Product product = new Product(id, name, price);
            productManager.addProduct(product);
        });

        VBox vbox = new VBox(10, idField, nameField, priceField, addButton);
        Scene scene = new Scene(vbox, 300, 200);
        window.setScene(scene);
        window.show();
    }
}
