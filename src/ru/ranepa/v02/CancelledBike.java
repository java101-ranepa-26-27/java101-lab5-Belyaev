package ru.ranepa.v02;

public class CancelledBike extends Bike {

    public CancelledBike(String id, String name, BikeKind kind, double price) {
        super(id, name, kind, price);
    }

    @Override
    public void confirm() {
        throw new UnsupportedOperationException("у велосипеда повреждена рама");
    }
}
