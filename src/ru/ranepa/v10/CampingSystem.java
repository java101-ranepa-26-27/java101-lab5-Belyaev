package ru.ranepa.v10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CampingSystem {

    private static final CampingSystem INSTANCE = new CampingSystem();

    private final Map<String, CampingSpot> records = new HashMap<>();
    private final List<Staff> staff = new ArrayList<>();
    private final SmsGateway smsGateway = new SmsGateway();
    private final Ledger ledger = new Ledger();

    private CampingSystem() {
    }

    public static CampingSystem getInstance() {
        return INSTANCE;
    }

    public CampingSpot book(String id, String name, CampingSpotKind kind, double basePrice) {
        CampingSpot item = new CampingSpot(id, name, kind, priceFor(kind, basePrice));
        records.put(name, item);
        smsGateway.send(name, "Место добавлено");
        ledger.write("book;" + name + ";" + item.price);
        return item;
    }

    public void addRecord(CampingSpot item) {
        records.put(item.name, item);
    }

    public void addStaff(Staff member) {
        staff.add(member);
    }

    public void confirmAll() {
        for (CampingSpot item : records.values()) {
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

    public double priceFor(CampingSpotKind kind, double base) {
        switch (kind) {
            case TENT:
                return base;
            case CARAVAN:
                return base * 1.2;
            case GLAMPING:
                return base * 0.8;
            default:
                return base;
        }
    }

    public double total() {
        double sum = 0;
        for (CampingSpot item : records.values()) {
            sum += item.price;
        }
        return sum;
    }

    public void printQueue() {
        for (CampingSpot item : records.values()) {
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

    public CampingSpot find(String name) {
        return records.get(name);
    }

    public void closeDay() {
        for (CampingSpot item : records.values()) {
            ledger.write("day;" + item.name + ";" + item.price);
        }
        for (Staff member : staff) {
            smsGateway.send(member.name(), "Завтра поход");
        }
    }
}
