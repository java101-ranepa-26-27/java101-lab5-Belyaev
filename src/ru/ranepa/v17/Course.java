package ru.ranepa.v17;

public abstract class Course {

    public String name;
    public double price;
    public boolean available;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public void start() {
        System.out.println(name + " запущен");
    }

    public String role() {
        return "курс";
    }
}
