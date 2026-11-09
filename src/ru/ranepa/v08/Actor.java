package ru.ranepa.v08;

public interface Actor {

    String name();

    void process(Exhibit item);

    void escalate(Exhibit item);

    void comment(Exhibit item);

    void notify(Exhibit item);

    void close(Exhibit item);
}
