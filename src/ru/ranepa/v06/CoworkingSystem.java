package ru.ranepa.v06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoworkingSystem {

    private static final CoworkingSystem INSTANCE = new CoworkingSystem();

    private final Map<String, Workspace> records = new HashMap<>();
    private final List<Staff> staff = new ArrayList<>();
    private final SmsGateway smsGateway = new SmsGateway();
    private final Ledger ledger = new Ledger();

    private CoworkingSystem() {
    }

    public static CoworkingSystem getInstance() {
        return INSTANCE;
    }

    public Workspace book(String id, String name, WorkspaceKind kind, double basePrice) {
        Workspace item = new Workspace(id, name, kind, priceFor(kind, basePrice));
        records.put(name, item);
        smsGateway.send(name, "Место добавлено");
        ledger.write("book;" + name + ";" + item.price);
        return item;
    }

    public void addRecord(Workspace item) {
        records.put(item.name, item);
    }

    public void addStaff(Staff member) {
        staff.add(member);
    }

    public void confirmAll() {
        for (Workspace item : records.values()) {
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

    public double priceFor(WorkspaceKind kind, double base) {
        switch (kind) {
            case DESK:
                return base;
            case MEETING:
                return base * 1.2;
            case QUIET:
                return base * 0.8;
            default:
                return base;
        }
    }

    public double total() {
        double sum = 0;
        for (Workspace item : records.values()) {
            sum += item.price;
        }
        return sum;
    }

    public void printQueue() {
        for (Workspace item : records.values()) {
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

    public Workspace find(String name) {
        return records.get(name);
    }

    public void closeDay() {
        for (Workspace item : records.values()) {
            ledger.write("day;" + item.name + ";" + item.price);
        }
        for (Staff member : staff) {
            smsGateway.send(member.name(), "Завтра отключение интернета");
        }
    }
}
