package ru.ranepa.v07;

public class Instrument {

    public String name;
    public String kind;
    public double price;
    public String status;

    public Instrument(String name, String kind, double price) {
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.status = "новый";
    }
}
