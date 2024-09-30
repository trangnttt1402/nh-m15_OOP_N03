package com.example.trangg.view;

import com.example.trangg.controller.OrderManager;
import com.example.trangg.model.Order;
import com.example.trangg.model.OrderItem;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class OrderEntryWindow {
    private static List<OrderItem> orderItems = new ArrayList<>();

    public static void display(Stage primaryStage, OrderManager orderManager) {
        primaryStage.setTitle("Enter Order Information");

        // Labels and TextFields for Order Input
        Label orderIdLabel = new Label("Order ID:");
        TextField orderIdField = new TextField();
        Label productIdLabel = new Label("Product ID:");
        TextField productIdField = new TextField();
        Label quantityLabel = new Label("Quantity:");
        TextField quantityField = new TextField();

        // Area to display items added to the order
        TextArea orderItemsArea = new TextArea();
        orderItemsArea.setEditable(false);
        orderItemsArea.setPromptText("Order items will be listed here...");

        Button addItemButton = new Button("Add Item");
        addItemButton.setOnAction(e -> {
            String productId = productIdField.getText().trim();
            String quantityText = quantityField.getText().trim();

            if (productId.isEmpty() || quantityText.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Invalid Input", "All fields must be filled.");
                return;
            }

            try {
                int quantity = Integer.parseInt(quantityText);
                if (quantity <= 0) {
                    showAlert(Alert.AlertType.WARNING, "Invalid Quantity", "Quantity must be a positive number.");
                    return;
                }


                OrderItem item = new OrderItem(productId, quantity, 0); // Assuming 0 for price as placeholder
                orderItems.add(item);

                orderItemsArea.appendText("Product ID: " + productId + ", Quantity: " + quantity + "\n");

                productIdField.clear();
                quantityField.clear();

            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Quantity must be a valid number.");
            }
        });


        Button submitButton = new Button("Submit Order");
        submitButton.setOnAction(e -> {
            String orderId = orderIdField.getText().trim();


            if (orderId.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Invalid Input", "Order ID must be filled.");
                return;
            }

            if (orderItems.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Empty Order", "No items added to the order. Please add items.");
                return;
            }

            Order order = new Order(orderId, orderItems);
            orderManager.addOrder(order);

            showAlert(Alert.AlertType.INFORMATION, "Success", "Order added successfully.");
            orderIdField.clear();
            orderItemsArea.clear();
            orderItems.clear(); // Clear the list of items

            System.out.println("Order submitted with ID: " + orderId);
        });


        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {

            MainWindow.display(primaryStage, null, orderManager);
        });


        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                orderIdLabel, orderIdField,
                productIdLabel, productIdField,
                quantityLabel, quantityField,
                addItemButton, orderItemsArea,
                submitButton, backButton
        );

        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
