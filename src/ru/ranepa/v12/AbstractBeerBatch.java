package ru.ranepa.v12;

public abstract class AbstractBeerBatch implements BeerBatch {

    private final String name;
    private double price;

    protected AbstractBeerBatch(String name, double price) {
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
