package ru.ranepa.v18;

public interface Staff {

    String name();

    void confirm(DanceClass item);

    void cancel(DanceClass item);

    void clean();

    String report();
}
