package ru.ranepa.v13;

public class Goat extends Animal {

    public Goat(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "коза";
    }
}
