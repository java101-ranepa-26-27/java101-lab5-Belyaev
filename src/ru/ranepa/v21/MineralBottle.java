package ru.ranepa.v21;

public class MineralBottle extends Bottle {

    public MineralBottle(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "минеральная";
    }
}
