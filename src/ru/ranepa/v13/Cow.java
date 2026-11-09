package ru.ranepa.v13;

public class Cow extends Animal {

    public Cow(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "корова";
    }
}
