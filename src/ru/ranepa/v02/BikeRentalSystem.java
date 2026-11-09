package ru.ranepa.v02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BikeRentalSystem {

    private static final BikeRentalSystem INSTANCE = new BikeRentalSystem();

    private final Map<String, Bike> records = new HashMap<>();
    private final List<Staff> staff = new ArrayList<>();
    private final SmsGateway smsGateway = new SmsGateway();
    private final Ledger ledger = new Ledger();

    private BikeRentalSystem() {
    }

    public static BikeRentalSystem getInstance() {
        return INSTANCE;
    }

    public Bike book(String id, String name, BikeKind kind, double basePrice) {
        Bike item = new Bike(id, name, kind, priceFor(kind, basePrice));
        records.put(name, item);
        smsGateway.send(name, "Велосипед добавлен");
        ledger.write("book;" + name + ";" + item.price);
        return item;
    }

    public void addRecord(Bike item) {
        records.put(item.name, item);
    }

    public void addStaff(Staff member) {
        staff.add(member);
    }

    public void confirmAll() {
        for (Bike item : records.values()) {
            item.confirm();
        }
    }

    public void cancelByStaff(String staffName, String itemName) {
        Staff member = null;
        for (Staff candidate : staff) {
            if (candidate.name().equals(staffName)) {
                member = candidate;
            }
        }
        if (member == null) {
            throw new IllegalArgumentException("сотрудник не найден: " + staffName);
        }
        member.cancel(records.get(itemName));
    }

    public double priceFor(BikeKind kind, double base) {
        switch (kind) {
            case CITY:
                return base;
            case MOUNTAIN:
                return base * 1.2;
            case KIDS:
                return base * 0.8;
            default:
                return base;
        }
    }

    public double total() {
        double sum = 0;
        for (Bike item : records.values()) {
            sum += item.price;
        }
        return sum;
    }

    public void printQueue() {
        for (Bike item : records.values()) {
            System.out.println(item.id + " " + item.name + " [" + item.kind + "] "
                    + item.price + ", подтверждён: " + item.confirmed);
        }
        for (Staff member : staff) {
            System.out.println(member.report());
        }
    }

    public int count() {
        return records.size();
    }

    public Set<String> names() {
        return records.keySet();
    }

    public Bike find(String name) {
        return records.get(name);
    }

    public void closeDay() {
        for (Bike item : records.values()) {
            ledger.write("day;" + item.name + ";" + item.price);
        }
        for (Staff member : staff) {
            smsGateway.send(member.name(), "Завтра техосмотр");
        }
    }
}
