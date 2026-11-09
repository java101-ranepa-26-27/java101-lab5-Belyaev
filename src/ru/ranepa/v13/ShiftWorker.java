package ru.ranepa.v13;

public interface ShiftWorker {

    String name();

    void handle(Animal item);

    void clean();

    void openShift();

    double salary();

    String report();
}
