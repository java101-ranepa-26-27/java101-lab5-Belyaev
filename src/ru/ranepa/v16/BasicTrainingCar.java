package ru.ranepa.v16;

public class BasicTrainingCar extends AbstractTrainingCar {

    public BasicTrainingCar(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " поездка выполнена");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён");
    }
}
