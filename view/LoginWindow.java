package com.example.trangg.view;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.example.trangg.MainApp;

public class LoginWindow {

    public static void display(Stage primaryStage, MainApp mainApp) {
        primaryStage.setTitle("Login");

        Label nameLabel = new Label("Username:");
        TextField nameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");

        loginButton.setOnAction(e -> {
            String username = nameField.getText();
            String password = passwordField.getText();


            if (username.isEmpty() || password.isEmpty()) {
                showAlert("Error", "Please enter both username and password.");
                return;
            }

            System.out.println("Login button clicked for user: " + username);
            mainApp.showMainWindow(primaryStage); // Transition to the main window
        });

        registerButton.setOnAction(e -> {

            System.out.println("Register button clicked");

        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(nameLabel, nameField, passwordLabel, passwordField, loginButton, registerButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
