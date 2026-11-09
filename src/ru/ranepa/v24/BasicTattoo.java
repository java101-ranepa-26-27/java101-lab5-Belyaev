package ru.ranepa.v24;

public class BasicTattoo extends AbstractTattoo {

    public BasicTattoo(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " нанесена");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён");
    }
}
