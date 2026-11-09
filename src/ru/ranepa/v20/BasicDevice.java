package ru.ranepa.v20;

public class BasicDevice extends AbstractDevice {

    public BasicDevice(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " отремонтировано");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён");
    }
}
