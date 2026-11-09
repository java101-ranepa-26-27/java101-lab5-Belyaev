package ru.ranepa.v16;

public class PremiumTrainingCar extends AbstractTrainingCar {

    public PremiumTrainingCar(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " поездка выполнена (приоритет)");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён с возвратом");
    }
}
