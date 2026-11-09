package ru.ranepa.v05;

public class DelicateShirt extends Shirt {

    public DelicateShirt(String name, double price) {
        super(name, price);
    }

    @Override
    public void wash() {
        throw new UnsupportedOperationException("шёлк нельзя стирать в этой машине");
    }
}
