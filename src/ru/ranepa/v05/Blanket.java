package ru.ranepa.v05;

public class Blanket extends LaundryItem {

    public Blanket(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "одеяло";
    }
}
