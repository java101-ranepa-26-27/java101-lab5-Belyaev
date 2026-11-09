package ru.ranepa.v15;

public class Show {

    public String name;
    public String kind;
    public double price;
    public String status;

    public Show(String name, String kind, double price) {
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.status = "новый";
    }
}
