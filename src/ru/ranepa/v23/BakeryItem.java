package ru.ranepa.v23;

public class BakeryItem {

    public String name;
    public String kind;
    public double price;
    public String status;

    public BakeryItem(String name, String kind, double price) {
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.status = "новый";
    }
}
