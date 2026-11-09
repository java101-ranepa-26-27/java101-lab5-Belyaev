package ru.ranepa.v01;

public class Coffee extends Drink {

    public Coffee(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "кофе";
    }
}
