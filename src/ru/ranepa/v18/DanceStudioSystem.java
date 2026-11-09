package ru.ranepa.v18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DanceStudioSystem {

    private static final DanceStudioSystem INSTANCE = new DanceStudioSystem();

    private final Map<String, DanceClass> records = new HashMap<>();
    private final List<Staff> staff = new ArrayList<>();
    private final SmsGateway smsGateway = new SmsGateway();
    private final Ledger ledger = new Ledger();

    private DanceStudioSystem() {
    }

    public static DanceStudioSystem getInstance() {
        return INSTANCE;
    }

    public DanceClass book(String id, String name, DanceClassKind kind, double basePrice) {
        DanceClass item = new DanceClass(id, name, kind, priceFor(kind, basePrice));
        records.put(name, item);
        smsGateway.send(name, "Занятие добавлено");
        ledger.write("book;" + name + ";" + item.price);
        return item;
    }

    public void addRecord(DanceClass item) {
        records.put(item.name, item);
    }

    public void addStaff(Staff member) {
        staff.add(member);
    }

    public void confirmAll() {
        for (DanceClass item : records.values()) {
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

    public double priceFor(DanceClassKind kind, double base) {
        switch (kind) {
            case SALSA:
                return base;
            case BALLET:
                return base * 1.2;
            case HIPHOP:
                return base * 0.8;
            default:
                return base;
        }
    }

    public double total() {
        double sum = 0;
        for (DanceClass item : records.values()) {
            sum += item.price;
        }
        return sum;
    }

    public void printQueue() {
        for (DanceClass item : records.values()) {
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

    public DanceClass find(String name) {
        return records.get(name);
    }

    public void closeDay() {
        for (DanceClass item : records.values()) {
            ledger.write("day;" + item.name + ";" + item.price);
        }
        for (Staff member : staff) {
            smsGateway.send(member.name(), "Завтра отчётный концерт");
        }
    }
}
