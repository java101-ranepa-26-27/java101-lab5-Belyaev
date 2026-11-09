package ru.ranepa.v07;

public class InstrumentUtils {

    public static Instrument create(String name, String kind, double price) {
        Instrument item = new Instrument(name, kind, priceFor(kind, price));
        InstrumentStore.ITEMS.put(name, item);
        new Notifier().send(name, "Инструмент добавлен");
        return item;
    }

    public static double priceFor(String kind, double base) {
        if (kind.equals("piano")) {
            return base;
        }
        if (kind.equals("guitar")) {
            return base * 1.2;
        }
        if (kind.equals("violin")) {
            return base * 0.8;
        }
        return base;
    }

    public static void processAll() {
        for (Instrument item : InstrumentStore.ITEMS.values()) {
            if (item.kind.equals("piano")) {
                System.out.println(item.name + " сыгран");
            } else if (item.kind.equals("guitar")) {
                System.out.println(item.name + " сыгран");
            } else {
                System.out.println("Неизвестный инструмент: " + item.name);
            }
        }
    }

    public static void setStatus(String name, String status) {
        Instrument item = InstrumentStore.ITEMS.get(name);
        if (item == null) {
            throw new IllegalArgumentException("не найдено: " + name);
        }
        item.status = status;
        new Notifier().send(name, "Статус: " + status);
    }

    public static void printAll() {
        for (Instrument item : InstrumentStore.ITEMS.values()) {
            System.out.println(item.name + " (" + item.kind + "), " + item.price + ", " + item.status);
        }
    }

    public static int count() {
        return InstrumentStore.ITEMS.size();
    }

    public static Instrument find(String name) {
        return InstrumentStore.ITEMS.get(name);
    }
}
