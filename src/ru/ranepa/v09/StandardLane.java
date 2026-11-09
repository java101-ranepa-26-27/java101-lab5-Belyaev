package ru.ranepa.v09;

public class StandardLane extends Lane {

    public StandardLane(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "стандартная";
    }
}
