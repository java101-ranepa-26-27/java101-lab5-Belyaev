package ru.ranepa.v21;

public class LeakingBottle extends StillBottle {

    public LeakingBottle(String name, double price) {
        super(name, price);
    }

    @Override
    public void deliver() {
        throw new UnsupportedOperationException("бутыль протекает");
    }
}
