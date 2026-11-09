package ru.ranepa.v12;

public class PremiumBeerBatch extends AbstractBeerBatch {

    public PremiumBeerBatch(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " разлита (приоритет)");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён с возвратом");
    }
}
