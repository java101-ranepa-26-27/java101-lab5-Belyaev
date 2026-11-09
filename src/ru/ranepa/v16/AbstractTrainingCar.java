package ru.ranepa.v16;

public abstract class AbstractTrainingCar implements TrainingCar {

    private final String name;
    private double price;

    protected AbstractTrainingCar(String name, double price) {
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
