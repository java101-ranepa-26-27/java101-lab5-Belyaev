package ru.ranepa.v10;

public class CampingSpot {

    public String id;
    public String name;
    public CampingSpotKind kind;
    public double price;
    public boolean confirmed;

    public CampingSpot(String id, String name, CampingSpotKind kind, double price) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.confirmed = false;
    }

    public void confirm() {
        confirmed = true;
        System.out.println(name + " подтверждён");
    }

    public void cancel() {
        confirmed = false;
        System.out.println(name + " отменён");
    }
}
