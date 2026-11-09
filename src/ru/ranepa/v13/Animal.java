package ru.ranepa.v13;

public abstract class Animal {

    public String name;
    public double price;
    public boolean available;

    public Animal(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public void produce() {
        System.out.println(name + " даёт продукт");
    }

    public String role() {
        return "животное";
    }
}
