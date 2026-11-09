package ru.ranepa.v08;

public class BasicExhibit extends AbstractExhibit {

    public BasicExhibit(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " выставлен");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён");
    }
}
