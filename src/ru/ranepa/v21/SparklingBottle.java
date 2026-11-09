package ru.ranepa.v21;

public class SparklingBottle extends Bottle {

    public SparklingBottle(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "с газом";
    }
}
