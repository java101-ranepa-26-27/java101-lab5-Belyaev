package ru.ranepa.v04;

public class BasicPet extends AbstractPet {

    public BasicPet(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " подстрижен");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён");
    }
}
