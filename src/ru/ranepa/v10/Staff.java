package ru.ranepa.v10;

public interface Staff {

    String name();

    void confirm(CampingSpot item);

    void cancel(CampingSpot item);

    void clean();

    String report();
}
