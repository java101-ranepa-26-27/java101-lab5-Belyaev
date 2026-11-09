package ru.ranepa.v23;

public class BakeryItemUtils {

    public static BakeryItem create(String name, String kind, double price) {
        BakeryItem item = new BakeryItem(name, kind, priceFor(kind, price));
        BakeryItemStore.ITEMS.put(name, item);
        new Notifier().send(name, "Изделие добавлено");
        return item;
    }

    public static double priceFor(String kind, double base) {
        if (kind.equals("white")) {
            return base;
        }
        if (kind.equals("rye")) {
            return base * 1.2;
        }
        if (kind.equals("croissant")) {
            return base * 0.8;
        }
        return base;
    }

    public static void processAll() {
        for (BakeryItem item : BakeryItemStore.ITEMS.values()) {
            if (item.kind.equals("white")) {
                System.out.println(item.name + " испечён");
            } else if (item.kind.equals("rye")) {
                System.out.println(item.name + " испечён");
            } else {
                System.out.println("Неизвестное изделие: " + item.name);
            }
        }
    }

    public static void setStatus(String name, String status) {
        BakeryItem item = BakeryItemStore.ITEMS.get(name);
        if (item == null) {
            throw new IllegalArgumentException("не найдено: " + name);
        }
        item.status = status;
        new Notifier().send(name, "Статус: " + status);
    }

    public static void printAll() {
        for (BakeryItem item : BakeryItemStore.ITEMS.values()) {
            System.out.println(item.name + " (" + item.kind + "), " + item.price + ", " + item.status);
        }
    }

    public static int count() {
        return BakeryItemStore.ITEMS.size();
    }

    public static BakeryItem find(String name) {
        return BakeryItemStore.ITEMS.get(name);
    }
}
