package ru.ranepa.v01;

public class Tea extends Drink {

    public Tea(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "чай";
    }
}
