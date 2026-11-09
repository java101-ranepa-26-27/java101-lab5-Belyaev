package ru.ranepa.v24;

public class PremiumTattoo extends AbstractTattoo {

    public PremiumTattoo(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " нанесена (приоритет)");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён с возвратом");
    }
}
