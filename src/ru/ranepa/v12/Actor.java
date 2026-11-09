package ru.ranepa.v12;

public interface Actor {

    String name();

    void process(BeerBatch item);

    void escalate(BeerBatch item);

    void comment(BeerBatch item);

    void notify(BeerBatch item);

    void close(BeerBatch item);
}
