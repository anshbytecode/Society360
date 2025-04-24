package com.example.society360;

public class Resident {
    private String name;
    private String flatNumber;

    public Resident(String name, String flatNumber) {
        this.name = name;
        this.flatNumber = flatNumber;
    }

    public String getName() {
        return name;
    }

    public String getFlatNumber() {
        return flatNumber;
    }
}