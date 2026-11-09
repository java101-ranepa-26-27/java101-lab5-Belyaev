package ru.ranepa.v24;

public abstract class AbstractTattoo implements Tattoo {

    private final String name;
    private double price;

    protected AbstractTattoo(String name, double price) {
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
