package com.example.trangg.view;

import com.example.trangg.MainApp;
import com.example.trangg.controller.UserManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginWindow {
    public static void display(Stage primaryStage, MainApp mainApp) {
        primaryStage.setTitle("Đăng nhập");

        Label usernameLabel = new Label("Tên người dùng:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Mật khẩu:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Đăng nhập");

        UserManager userManager = new UserManager();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (userManager.authenticate(username, password) != null) {
                // Chuyển đến giao diện chính nếu đăng nhập thành công
                mainApp.showMainWindow(primaryStage);
            } else {
                // Hiển thị thông báo lỗi nếu đăng nhập thất bại
                System.out.println("Tên người dùng hoặc mật khẩu không đúng!");
            }
        });

        VBox vbox = new VBox(10, usernameLabel, usernameField, passwordLabel, passwordField, loginButton);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
