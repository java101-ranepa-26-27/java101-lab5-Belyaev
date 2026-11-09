package ru.ranepa.v23;

public interface Actor {

    void serve(BakeryItem item);

    void audit(BakeryItem item);

    void clean();

    void bill(BakeryItem item);
}
