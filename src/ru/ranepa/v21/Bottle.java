package ru.ranepa.v21;

public abstract class Bottle {

    public String name;
    public double price;
    public boolean available;

    public Bottle(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public void deliver() {
        System.out.println(name + " доставлена");
    }

    public String role() {
        return "бутыль";
    }
}
