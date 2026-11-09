package ru.ranepa.v19;

public interface Actor {

    void serve(Shoot item);

    void audit(Shoot item);

    void clean();

    void bill(Shoot item);
}
