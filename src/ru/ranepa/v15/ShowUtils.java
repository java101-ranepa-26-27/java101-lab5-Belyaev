package ru.ranepa.v15;

public class ShowUtils {

    public static Show create(String name, String kind, double price) {
        Show item = new Show(name, kind, priceFor(kind, price));
        ShowStore.ITEMS.put(name, item);
        new Notifier().send(name, "Шоу добавлено");
        return item;
    }

    public static double priceFor(String kind, double base) {
        if (kind.equals("star")) {
            return base;
        }
        if (kind.equals("planet")) {
            return base * 1.2;
        }
        if (kind.equals("kids")) {
            return base * 0.8;
        }
        return base;
    }

    public static void processAll() {
        for (Show item : ShowStore.ITEMS.values()) {
            if (item.kind.equals("star")) {
                System.out.println(item.name + " показано");
            } else if (item.kind.equals("planet")) {
                System.out.println(item.name + " показано");
            } else {
                System.out.println("Неизвестное шоу: " + item.name);
            }
        }
    }

    public static void setStatus(String name, String status) {
        Show item = ShowStore.ITEMS.get(name);
        if (item == null) {
            throw new IllegalArgumentException("не найдено: " + name);
        }
        item.status = status;
        new Notifier().send(name, "Статус: " + status);
    }

    public static void printAll() {
        for (Show item : ShowStore.ITEMS.values()) {
            System.out.println(item.name + " (" + item.kind + "), " + item.price + ", " + item.status);
        }
    }

    public static int count() {
        return ShowStore.ITEMS.size();
    }

    public static Show find(String name) {
        return ShowStore.ITEMS.get(name);
    }
}
