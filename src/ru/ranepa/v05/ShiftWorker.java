package ru.ranepa.v05;

public interface ShiftWorker {

    String name();

    void handle(LaundryItem item);

    void clean();

    void openShift();

    double salary();

    String report();
}
