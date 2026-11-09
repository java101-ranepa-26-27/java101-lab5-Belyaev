package ru.ranepa.v20;

public class PremiumDevice extends AbstractDevice {

    public PremiumDevice(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " отремонтировано (приоритет)");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён с возвратом");
    }
}
