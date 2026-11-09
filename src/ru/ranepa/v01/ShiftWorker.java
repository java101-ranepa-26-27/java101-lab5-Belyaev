package ru.ranepa.v01;

public interface ShiftWorker {

    String name();

    void handle(Drink item);

    void clean();

    void openShift();

    double salary();

    String report();
}
