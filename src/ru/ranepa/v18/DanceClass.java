package ru.ranepa.v18;

public class DanceClass {

    public String id;
    public String name;
    public DanceClassKind kind;
    public double price;
    public boolean confirmed;

    public DanceClass(String id, String name, DanceClassKind kind, double price) {
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
