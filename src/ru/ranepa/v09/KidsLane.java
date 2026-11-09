package ru.ranepa.v09;

public class KidsLane extends Lane {

    public KidsLane(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "детская";
    }
}
