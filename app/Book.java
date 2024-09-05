package com.mycompany.app;

public class Book {
    private final String ten;
    private final String tacGia;

    public Book(String ten, String tacGia) {
        this.ten = ten;
        this.tacGia = tacGia;
    }

    public String getTen() {
        return ten;
    }

    public String getTacGia() {
        return tacGia;
    }
}
