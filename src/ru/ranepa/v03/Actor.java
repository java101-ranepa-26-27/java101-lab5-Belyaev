package ru.ranepa.v03;

public interface Actor {

    void serve(Bouquet item);

    void audit(Bouquet item);

    void clean();

    void bill(Bouquet item);
}
