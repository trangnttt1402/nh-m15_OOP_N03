package com.example.trangg.view;

import com.example.trangg.controller.ProductManager;
import com.example.trangg.model.Product;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductEntryWindow {

    public static void display(Stage primaryStage, ProductManager productManager) {
        primaryStage.setTitle("Enter Product Information");


        Label productIdLabel = new Label("Product ID:");
        TextField productIdField = new TextField();
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label priceLabel = new Label("Price:");
        TextField priceField = new TextField();
        Label stockLabel = new Label("Stock:");
        TextField stockField = new TextField();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String productId = productIdField.getText().trim();
            String name = nameField.getText().trim();
            String priceText = priceField.getText().trim();
            String stockText = stockField.getText().trim();

            if (productId.isEmpty() || name.isEmpty() || priceText.isEmpty() || stockText.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Invalid Input", "All fields must be filled.");
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                int stock = Integer.parseInt(stockText);


                Product product = new Product(productId, name, price, stock);
                productManager.addProduct(product);

                productIdField.clear();
                nameField.clear();
                priceField.clear();
                stockField.clear();

                showAlert(Alert.AlertType.INFORMATION, "Success", "Product added successfully.");

            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Price and Stock must be valid numbers.");
            }
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {

            MainWindow.display(primaryStage, productManager, null);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                productIdLabel, productIdField, nameLabel, nameField,
                priceLabel, priceField, stockLabel, stockField,
                submitButton, backButton
        );

        Scene scene = new Scene(layout, 300, 400);
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
