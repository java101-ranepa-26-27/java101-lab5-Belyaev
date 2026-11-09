package ru.ranepa.v09;

public class VIPLane extends Lane {

    public VIPLane(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "VIP";
    }
}
