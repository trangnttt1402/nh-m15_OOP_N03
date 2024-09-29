package com.example.trangg.view;

import com.example.trangg.controller.ProductManager;
import com.example.trangg.controller.OrderManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow {
    public static void display(Stage primaryStage, ProductManager productManager, OrderManager orderManager) {
        primaryStage.setTitle("Quản lý bán hàng");

        Button productButton = new Button("Quản lý sản phẩm");
        Button orderButton = new Button("Quản lý đơn hàng");

        productButton.setOnAction(e -> ProductWindow.display(productManager));
        orderButton.setOnAction(e -> OrderWindow.display(orderManager));

        VBox vbox = new VBox(10, productButton, orderButton);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
