package ru.ranepa.v24;

public interface Actor {

    String name();

    void process(Tattoo item);

    void escalate(Tattoo item);

    void comment(Tattoo item);

    void notify(Tattoo item);

    void close(Tattoo item);
}
