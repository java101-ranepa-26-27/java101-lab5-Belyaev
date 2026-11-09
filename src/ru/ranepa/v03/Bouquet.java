package ru.ranepa.v03;

public class Bouquet {

    public String name;
    public String kind;
    public double price;
    public String status;

    public Bouquet(String name, String kind, double price) {
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.status = "новый";
    }
}
