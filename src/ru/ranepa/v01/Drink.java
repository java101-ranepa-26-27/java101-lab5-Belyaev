package ru.ranepa.v01;

public abstract class Drink {

    public String name;
    public double price;
    public boolean available;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public void brew() {
        System.out.println(name + " приготовлен");
    }

    public String role() {
        return "напиток";
    }
}
