package ru.ranepa.v06;

public interface Staff {

    String name();

    void confirm(Workspace item);

    void cancel(Workspace item);

    void clean();

    String report();
}
