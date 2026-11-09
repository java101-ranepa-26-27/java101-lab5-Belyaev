package ru.ranepa.v05;

public class Shirt extends LaundryItem {

    public Shirt(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "рубашка";
    }
}
