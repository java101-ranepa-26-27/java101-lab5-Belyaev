package ru.ranepa.v01;

public class DecafCoffee extends Coffee {

    public DecafCoffee(String name, double price) {
        super(name, price);
    }

    @Override
    public void brew() {
        throw new UnsupportedOperationException("декаф не готовится на этой машине");
    }
}
