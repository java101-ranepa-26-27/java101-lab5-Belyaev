package ru.ranepa.v11;

public interface Actor {

    void serve(Publication item);

    void audit(Publication item);

    void clean();

    void bill(Publication item);
}
