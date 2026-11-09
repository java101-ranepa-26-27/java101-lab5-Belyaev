package ru.ranepa.v12;

public class BasicBeerBatch extends AbstractBeerBatch {

    public BasicBeerBatch(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " разлита");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён");
    }
}
