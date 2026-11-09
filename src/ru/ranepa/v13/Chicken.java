package ru.ranepa.v13;

public class Chicken extends Animal {

    public Chicken(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "курица";
    }
}
