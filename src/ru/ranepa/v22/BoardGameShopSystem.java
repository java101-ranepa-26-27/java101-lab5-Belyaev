package ru.ranepa.v22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BoardGameShopSystem {

    private static final BoardGameShopSystem INSTANCE = new BoardGameShopSystem();

    private final Map<String, BoardGame> records = new HashMap<>();
    private final List<Staff> staff = new ArrayList<>();
    private final SmsGateway smsGateway = new SmsGateway();
    private final Ledger ledger = new Ledger();

    private BoardGameShopSystem() {
    }

    public static BoardGameShopSystem getInstance() {
        return INSTANCE;
    }

    public BoardGame book(String id, String name, BoardGameKind kind, double basePrice) {
        BoardGame item = new BoardGame(id, name, kind, priceFor(kind, basePrice));
        records.put(name, item);
        smsGateway.send(name, "Игра добавлена");
        ledger.write("book;" + name + ";" + item.price);
        return item;
    }

    public void addRecord(BoardGame item) {
        records.put(item.name, item);
    }

    public void addStaff(Staff member) {
        staff.add(member);
    }

    public void confirmAll() {
        for (BoardGame item : records.values()) {
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

    public double priceFor(BoardGameKind kind, double base) {
        switch (kind) {
            case STRATEGY:
                return base;
            case PARTY:
                return base * 1.2;
            case FAMILY:
                return base * 0.8;
            default:
                return base;
        }
    }

    public double total() {
        double sum = 0;
        for (BoardGame item : records.values()) {
            sum += item.price;
        }
        return sum;
    }

    public void printQueue() {
        for (BoardGame item : records.values()) {
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

    public BoardGame find(String name) {
        return records.get(name);
    }

    public void closeDay() {
        for (BoardGame item : records.values()) {
            ledger.write("day;" + item.name + ";" + item.price);
        }
        for (Staff member : staff) {
            smsGateway.send(member.name(), "Завтра игротека");
        }
    }
}
