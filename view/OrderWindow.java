package com.example.trangg.view;

import com.example.trangg.controller.OrderManager;
import com.example.trangg.model.Order;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OrderWindow {
    public static void display(OrderManager orderManager) {
        Stage window = new Stage();
        window.setTitle("Quản lý đơn hàng");

        TextField orderIdField = new TextField();
        orderIdField.setPromptText("Mã đơn hàng");

        Button addButton = new Button("Thêm đơn hàng");
        addButton.setOnAction(e -> {
            String orderId = orderIdField.getText();
            Order order = new Order(orderId);  // Using the overloaded constructor
            orderManager.addOrder(order);
        });

        VBox vbox = new VBox(10, orderIdField, addButton);
        Scene scene = new Scene(vbox, 300, 200);
        window.setScene(scene);
        window.show();
    }
}
