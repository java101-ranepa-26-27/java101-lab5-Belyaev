package ru.ranepa.v13;

public class SickCow extends Cow {

    public SickCow(String name, double price) {
        super(name, price);
    }

    @Override
    public void produce() {
        throw new UnsupportedOperationException("корова больна");
    }
}
