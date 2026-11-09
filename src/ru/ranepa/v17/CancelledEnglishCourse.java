package ru.ranepa.v17;

public class CancelledEnglishCourse extends EnglishCourse {

    public CancelledEnglishCourse(String name, double price) {
        super(name, price);
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("курс отменён");
    }
}
