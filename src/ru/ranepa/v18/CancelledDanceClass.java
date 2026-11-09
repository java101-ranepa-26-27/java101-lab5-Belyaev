package ru.ranepa.v18;

public class CancelledDanceClass extends DanceClass {

    public CancelledDanceClass(String id, String name, DanceClassKind kind, double price) {
        super(id, name, kind, price);
    }

    @Override
    public void confirm() {
        throw new UnsupportedOperationException("занятие отменено");
    }
}
