package ru.ranepa.v10;

public class CancelledCampingSpot extends CampingSpot {

    public CancelledCampingSpot(String id, String name, CampingSpotKind kind, double price) {
        super(id, name, kind, price);
    }

    @Override
    public void confirm() {
        throw new UnsupportedOperationException("место затоплено");
    }
}
