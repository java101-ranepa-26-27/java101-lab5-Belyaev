package ru.ranepa.v08;

public abstract class AbstractExhibit implements Exhibit {

    private final String name;
    private double price;

    protected AbstractExhibit(String name, double price) {
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
