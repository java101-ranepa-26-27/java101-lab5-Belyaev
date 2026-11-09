package ru.ranepa.v16;

public class ArchivedTrainingCar extends BasicTrainingCar {

    public ArchivedTrainingCar(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException("автомобиль неисправен");
    }
}
