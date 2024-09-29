package com.example.trangg.controller;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, String> users = new HashMap<>();

    public UserManager() {
        users.put("admin", "password123");
    }

    public String authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return username;
        }
        return null;
    }
}
