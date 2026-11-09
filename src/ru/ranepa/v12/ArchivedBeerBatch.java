package ru.ranepa.v12;

public class ArchivedBeerBatch extends BasicBeerBatch {

    public ArchivedBeerBatch(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException("партия скисла");
    }
}
