package com.example.trangg.view;

import com.example.trangg.controller.OrderManager;
import com.example.trangg.model.Order;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OrderWindow {
    public static void display(OrderManager orderManager) {
        Stage window = new Stage();
        window.setTitle("Quản lý đơn hàng");
        window.initModality(Modality.APPLICATION_MODAL); // Set modality to block other windows

        TextField orderIdField = new TextField();
        orderIdField.setPromptText("Mã đơn hàng");

        Button addButton = new Button("Thêm đơn hàng");
        addButton.setOnAction(e -> {
            String orderId = orderIdField.getText().trim();
            if (!orderId.isEmpty()) {
                Order order = new Order(orderId);

                orderIdField.clear();

                showAlert(Alert.AlertType.INFORMATION, "Success", "Order added successfully.");
            } else {
                showAlert(Alert.AlertType.WARNING, "Invalid Input", "Order ID cannot be empty.");
            }
        });

        VBox vbox = new VBox(10, orderIdField, addButton);
        Scene scene = new Scene(vbox, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
