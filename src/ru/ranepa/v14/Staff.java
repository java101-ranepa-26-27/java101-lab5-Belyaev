package ru.ranepa.v14;

public interface Staff {

    String name();

    void confirm(SeaCreature item);

    void cancel(SeaCreature item);

    void clean();

    String report();
}
