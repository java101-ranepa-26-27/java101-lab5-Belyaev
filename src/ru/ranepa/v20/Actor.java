package ru.ranepa.v20;

public interface Actor {

    String name();

    void process(Device item);

    void escalate(Device item);

    void comment(Device item);

    void notify(Device item);

    void close(Device item);
}
