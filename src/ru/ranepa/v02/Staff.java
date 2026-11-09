package ru.ranepa.v02;

public interface Staff {

    String name();

    void confirm(Bike item);

    void cancel(Bike item);

    void clean();

    String report();
}
