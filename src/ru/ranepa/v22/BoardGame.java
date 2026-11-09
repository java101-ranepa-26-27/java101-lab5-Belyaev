package ru.ranepa.v22;

public class BoardGame {

    public String id;
    public String name;
    public BoardGameKind kind;
    public double price;
    public boolean confirmed;

    public BoardGame(String id, String name, BoardGameKind kind, double price) {
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
