package ru.ranepa.v04;

public abstract class AbstractPet implements Pet {

    private final String name;
    private double price;

    protected AbstractPet(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
