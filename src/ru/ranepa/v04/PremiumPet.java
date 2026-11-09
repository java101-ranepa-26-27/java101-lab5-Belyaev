package ru.ranepa.v04;

public class PremiumPet extends AbstractPet {

    public PremiumPet(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " подстрижен (приоритет)");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён с возвратом");
    }
}
