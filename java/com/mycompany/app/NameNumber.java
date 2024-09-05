package com.mycompany.app;

public class NameNumber {
    private final String name;
    private final int number;

    public NameNumber(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}