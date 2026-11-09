package ru.ranepa.v21;

public interface ShiftWorker {

    String name();

    void handle(Bottle item);

    void clean();

    void openShift();

    double salary();

    String report();
}
