package ru.ranepa.v14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AquariumSystem {

    private static final AquariumSystem INSTANCE = new AquariumSystem();

    private final Map<String, SeaCreature> records = new HashMap<>();
    private final List<Staff> staff = new ArrayList<>();
    private final SmsGateway smsGateway = new SmsGateway();
    private final Ledger ledger = new Ledger();

    private AquariumSystem() {
    }

    public static AquariumSystem getInstance() {
        return INSTANCE;
    }

    public SeaCreature book(String id, String name, SeaCreatureKind kind, double basePrice) {
        SeaCreature item = new SeaCreature(id, name, kind, priceFor(kind, basePrice));
        records.put(name, item);
        smsGateway.send(name, "Обитатель добавлен");
        ledger.write("book;" + name + ";" + item.price);
        return item;
    }

    public void addRecord(SeaCreature item) {
        records.put(item.name, item);
    }

    public void addStaff(Staff member) {
        staff.add(member);
    }

    public void confirmAll() {
        for (SeaCreature item : records.values()) {
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

    public double priceFor(SeaCreatureKind kind, double base) {
        switch (kind) {
            case SHARK:
                return base;
            case CLOWN:
                return base * 1.2;
            case JELLY:
                return base * 0.8;
            default:
                return base;
        }
    }

    public double total() {
        double sum = 0;
        for (SeaCreature item : records.values()) {
            sum += item.price;
        }
        return sum;
    }

    public void printQueue() {
        for (SeaCreature item : records.values()) {
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

    public SeaCreature find(String name) {
        return records.get(name);
    }

    public void closeDay() {
        for (SeaCreature item : records.values()) {
            ledger.write("day;" + item.name + ";" + item.price);
        }
        for (Staff member : staff) {
            smsGateway.send(member.name(), "Завтра кормление акул");
        }
    }
}
