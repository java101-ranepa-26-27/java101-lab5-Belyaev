package ru.ranepa.v20;

public abstract class AbstractDevice implements Device {

    private final String name;
    private double price;

    protected AbstractDevice(String name, double price) {
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
