package ru.ranepa.v07;

public interface Actor {

    void serve(Instrument item);

    void audit(Instrument item);

    void clean();

    void bill(Instrument item);
}
