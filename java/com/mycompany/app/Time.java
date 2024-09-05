package com.mycompany.app;

public class Time {
    private final int gio;
    private final int phut;

    // Constructor
    public Time(int gio, int phut) {
        this.gio = gio;
        this.phut = phut;
    }

    // Getter cho thuộc tính gio
    public int getGio() {
        return gio;
    }

    // Getter cho thuộc tính phut
    public int getPhut() {
        return phut;
    }
}