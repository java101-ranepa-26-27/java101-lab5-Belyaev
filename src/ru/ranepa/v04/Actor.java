package ru.ranepa.v04;

public interface Actor {

    String name();

    void process(Pet item);

    void escalate(Pet item);

    void comment(Pet item);

    void notify(Pet item);

    void close(Pet item);
}
