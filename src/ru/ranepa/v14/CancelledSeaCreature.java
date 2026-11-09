package ru.ranepa.v14;

public class CancelledSeaCreature extends SeaCreature {

    public CancelledSeaCreature(String id, String name, SeaCreatureKind kind, double price) {
        super(id, name, kind, price);
    }

    @Override
    public void confirm() {
        throw new UnsupportedOperationException("обитатель на карантине");
    }
}
