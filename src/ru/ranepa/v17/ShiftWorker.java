package ru.ranepa.v17;

public interface ShiftWorker {

    String name();

    void handle(Course item);

    void clean();

    void openShift();

    double salary();

    String report();
}
