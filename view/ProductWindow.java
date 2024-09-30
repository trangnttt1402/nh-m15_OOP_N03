package com.example.trangg.view;

import com.example.trangg.controller.ProductManager;
import com.example.trangg.model.Product;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProductWindow {
    public static void display(ProductManager productManager) {
        Stage window = new Stage();
        window.setTitle("Quản lý sản phẩm");
        window.initModality(Modality.APPLICATION_MODAL);

        TextField idField = new TextField();
        idField.setPromptText("Mã sản phẩm");
        TextField nameField = new TextField();
        nameField.setPromptText("Tên sản phẩm");
        TextField priceField = new TextField();
        priceField.setPromptText("Giá sản phẩm");

        Button addButton = new Button("Thêm sản phẩm");
        addButton.setOnAction(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String priceText = priceField.getText().trim();

            if (id.isEmpty() || name.isEmpty() || priceText.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Invalid Input", "All fields must be filled.");
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                Product product = new Product(id, name, price);
                productManager.addProduct(product);

                idField.clear();
                nameField.clear();
                priceField.clear();

                showAlert(Alert.AlertType.INFORMATION, "Success", "Product added successfully.");
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid Price", "Price must be a valid number.");
            }
        });

        VBox vbox = new VBox(10, idField, nameField, priceField, addButton);
        Scene scene = new Scene(vbox, 300, 250);
        window.setScene(scene);
        window.showAndWait();
    }


    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
