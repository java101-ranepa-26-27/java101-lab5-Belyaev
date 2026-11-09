package ru.ranepa.v14;

public class SeaCreature {

    public String id;
    public String name;
    public SeaCreatureKind kind;
    public double price;
    public boolean confirmed;

    public SeaCreature(String id, String name, SeaCreatureKind kind, double price) {
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
