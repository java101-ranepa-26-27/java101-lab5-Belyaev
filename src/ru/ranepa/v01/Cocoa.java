package ru.ranepa.v01;

public class Cocoa extends Drink {

    public Cocoa(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "какао";
    }
}
