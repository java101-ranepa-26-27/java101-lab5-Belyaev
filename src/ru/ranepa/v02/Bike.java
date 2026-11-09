package ru.ranepa.v02;

public class Bike {

    public String id;
    public String name;
    public BikeKind kind;
    public double price;
    public boolean confirmed;

    public Bike(String id, String name, BikeKind kind, double price) {
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
