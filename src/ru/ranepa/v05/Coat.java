package ru.ranepa.v05;

public class Coat extends LaundryItem {

    public Coat(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "пальто";
    }
}
