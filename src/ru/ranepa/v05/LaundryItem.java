package ru.ranepa.v05;

public abstract class LaundryItem {

    public String name;
    public double price;
    public boolean available;

    public LaundryItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public void wash() {
        System.out.println(name + " постиран");
    }

    public String role() {
        return "изделие";
    }
}
