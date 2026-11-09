package ru.ranepa.v09;

public class BrokenLane extends StandardLane {

    public BrokenLane(String name, double price) {
        super(name, price);
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("дорожка сломана");
    }
}
