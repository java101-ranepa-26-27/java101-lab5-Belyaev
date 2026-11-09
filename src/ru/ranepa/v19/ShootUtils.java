package ru.ranepa.v19;

public class ShootUtils {

    public static Shoot create(String name, String kind, double price) {
        Shoot item = new Shoot(name, kind, priceFor(kind, price));
        ShootStore.ITEMS.put(name, item);
        new Notifier().send(name, "Съёмка добавлена");
        return item;
    }

    public static double priceFor(String kind, double base) {
        if (kind.equals("portrait")) {
            return base;
        }
        if (kind.equals("wedding")) {
            return base * 1.2;
        }
        if (kind.equals("product")) {
            return base * 0.8;
        }
        return base;
    }

    public static void processAll() {
        for (Shoot item : ShootStore.ITEMS.values()) {
            if (item.kind.equals("portrait")) {
                System.out.println(item.name + " снята");
            } else if (item.kind.equals("wedding")) {
                System.out.println(item.name + " снята");
            } else {
                System.out.println("Неизвестная съёмка: " + item.name);
            }
        }
    }

    public static void setStatus(String name, String status) {
        Shoot item = ShootStore.ITEMS.get(name);
        if (item == null) {
            throw new IllegalArgumentException("не найдено: " + name);
        }
        item.status = status;
        new Notifier().send(name, "Статус: " + status);
    }

    public static void printAll() {
        for (Shoot item : ShootStore.ITEMS.values()) {
            System.out.println(item.name + " (" + item.kind + "), " + item.price + ", " + item.status);
        }
    }

    public static int count() {
        return ShootStore.ITEMS.size();
    }

    public static Shoot find(String name) {
        return ShootStore.ITEMS.get(name);
    }
}
