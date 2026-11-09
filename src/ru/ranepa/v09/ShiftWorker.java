package ru.ranepa.v09;

public interface ShiftWorker {

    String name();

    void handle(Lane item);

    void clean();

    void openShift();

    double salary();

    String report();
}
