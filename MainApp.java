package com.example.trangg;

import javafx.application.Application;
import javafx.stage.Stage;
import com.example.trangg.controller.ProductManager;
import com.example.trangg.controller.OrderManager;
import com.example.trangg.view.LoginWindow;
import com.example.trangg.view.MainWindow;

public class MainApp extends Application {
    private ProductManager productManager = new ProductManager();
    private OrderManager orderManager = new OrderManager();

    @Override
    public void start(Stage primaryStage) {
        LoginWindow.display(primaryStage, this);
    }

    public void showMainWindow(Stage primaryStage) {
        MainWindow.display(primaryStage, productManager, orderManager);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
