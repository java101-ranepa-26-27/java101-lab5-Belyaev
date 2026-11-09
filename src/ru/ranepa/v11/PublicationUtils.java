package ru.ranepa.v11;

public class PublicationUtils {

    public static Publication create(String name, String kind, double price) {
        Publication item = new Publication(name, kind, priceFor(kind, price));
        PublicationStore.ITEMS.put(name, item);
        new Notifier().send(name, "Издание добавлено");
        return item;
    }

    public static double priceFor(String kind, double base) {
        if (kind.equals("flyer")) {
            return base;
        }
        if (kind.equals("book")) {
            return base * 1.2;
        }
        if (kind.equals("poster")) {
            return base * 0.8;
        }
        return base;
    }

    public static void processAll() {
        for (Publication item : PublicationStore.ITEMS.values()) {
            if (item.kind.equals("flyer")) {
                System.out.println(item.name + " напечатан");
            } else if (item.kind.equals("book")) {
                System.out.println(item.name + " напечатан");
            } else {
                System.out.println("Неизвестное издание: " + item.name);
            }
        }
    }

    public static void setStatus(String name, String status) {
        Publication item = PublicationStore.ITEMS.get(name);
        if (item == null) {
            throw new IllegalArgumentException("не найдено: " + name);
        }
        item.status = status;
        new Notifier().send(name, "Статус: " + status);
    }

    public static void printAll() {
        for (Publication item : PublicationStore.ITEMS.values()) {
            System.out.println(item.name + " (" + item.kind + "), " + item.price + ", " + item.status);
        }
    }

    public static int count() {
        return PublicationStore.ITEMS.size();
    }

    public static Publication find(String name) {
        return PublicationStore.ITEMS.get(name);
    }
}
