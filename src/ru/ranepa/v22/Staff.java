package ru.ranepa.v22;

public interface Staff {

    String name();

    void confirm(BoardGame item);

    void cancel(BoardGame item);

    void clean();

    String report();
}
