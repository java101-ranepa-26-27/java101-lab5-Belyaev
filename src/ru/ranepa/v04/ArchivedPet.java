package ru.ranepa.v04;

public class ArchivedPet extends BasicPet {

    public ArchivedPet(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException("собака кусается, груминг невозможен");
    }
}
