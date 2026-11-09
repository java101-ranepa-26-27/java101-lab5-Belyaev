package ru.ranepa.v09;

public abstract class Lane {

    public String name;
    public double price;
    public boolean available;

    public Lane(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public void play() {
        System.out.println(name + " сыграна");
    }

    public String role() {
        return "дорожка";
    }
}
