package ru.ranepa.v21;

public class StillBottle extends Bottle {

    public StillBottle(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "без газа";
    }
}
