package com.example.trangg.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.example.trangg.controller.ProductManager;
import com.example.trangg.controller.OrderManager;
import com.example.trangg.model.Product;
import com.example.trangg.model.Order;

public class ListViewWindow {

    public static void display(Stage primaryStage, ProductManager productManager, OrderManager orderManager) {
        primaryStage.setTitle("View Products and Orders");

        VBox layout = new VBox(10);


        populateProductList(layout, productManager);


        populateOrderList(layout, orderManager);


        Button backButton = new Button("Back");
        backButton.setOnAction(e -> MainWindow.display(primaryStage, productManager, orderManager));
        layout.getChildren().add(backButton);

        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void populateProductList(VBox layout, ProductManager productManager) {
        Label productListLabel = new Label("Product List:");
        layout.getChildren().add(productListLabel);

        if (productManager != null && !productManager.getProducts().isEmpty()) {
            for (Product product : productManager.getProducts()) {
                Label productLabel = new Label(
                        String.format("ID: %s, Name: %s, Price: %.2f, Stock: %d",
                                product.getProductId(), product.getName(), product.getPrice(), product.getStock())
                );
                layout.getChildren().add(productLabel);
            }
        } else {
            layout.getChildren().add(new Label("No products available."));
        }
    }


    private static void populateOrderList(VBox layout, OrderManager orderManager) {
        Label orderListLabel = new Label("Order List:");
        layout.getChildren().add(orderListLabel);

        if (orderManager != null && !orderManager.getOrders().isEmpty()) {
            for (Order order : orderManager.getOrders()) {
                Label orderLabel = new Label(
                        String.format("Order ID: %s, Total Amount: %.2f, Number of Items: %d",
                                order.getOrderId(), order.getTotalAmount(), order.getItems().size())
                );
                layout.getChildren().add(orderLabel);
            }
        } else {
            layout.getChildren().add(new Label("No orders available."));
        }
    }
}
