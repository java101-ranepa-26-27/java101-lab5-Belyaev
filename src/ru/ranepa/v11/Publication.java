package ru.ranepa.v11;

public class Publication {

    public String name;
    public String kind;
    public double price;
    public String status;

    public Publication(String name, String kind, double price) {
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.status = "новый";
    }
}
