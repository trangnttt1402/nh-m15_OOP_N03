package com.example.trangg.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.example.trangg.controller.ProductManager;
import com.example.trangg.controller.OrderManager;

public class MainWindow {

    public static void display(Stage primaryStage, ProductManager productManager, OrderManager orderManager) {
        primaryStage.setTitle("Main Window");

        Button enterProductButton = createButton("Enter Product Information",
                "Enter details of new products to add to the inventory.",
                e -> ProductEntryWindow.display(primaryStage, productManager));

        Button enterOrderButton = createButton("Enter Order Information",
                "Create a new order by entering product and quantity details.",
                e -> OrderEntryWindow.display(primaryStage, orderManager));

        Button viewListButton = createButton("View Products and Orders",
                "View a list of all products and orders in the system.",
                e -> ListViewWindow.display(primaryStage, productManager, orderManager));

        enterOrderButton.setDisable(productManager == null || productManager.getProducts().isEmpty());
        viewListButton.setDisable((productManager == null || productManager.getProducts().isEmpty()) &&
                (orderManager == null || orderManager.getOrders().isEmpty()));


        VBox layout = new VBox(15);
        layout.getChildren().addAll(enterProductButton, enterOrderButton, viewListButton);


        Scene scene = new Scene(layout, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static Button createButton(String text, String tooltipText, javafx.event.EventHandler<javafx.event.ActionEvent> eventHandler) {
        Button button = new Button(text);
        button.setTooltip(new Tooltip(tooltipText));
        button.setOnAction(eventHandler);
        return button;
    }
}
