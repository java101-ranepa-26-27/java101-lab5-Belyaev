package ru.ranepa.v03;

public class BouquetUtils {

    public static Bouquet create(String name, String kind, double price) {
        Bouquet item = new Bouquet(name, kind, priceFor(kind, price));
        BouquetStore.ITEMS.put(name, item);
        new Notifier().send(name, "Букет добавлен");
        return item;
    }

    public static double priceFor(String kind, double base) {
        if (kind.equals("rose")) {
            return base;
        }
        if (kind.equals("tulip")) {
            return base * 1.2;
        }
        if (kind.equals("mixed")) {
            return base * 0.8;
        }
        return base;
    }

    public static void processAll() {
        for (Bouquet item : BouquetStore.ITEMS.values()) {
            if (item.kind.equals("rose")) {
                System.out.println(item.name + " продан");
            } else if (item.kind.equals("tulip")) {
                System.out.println(item.name + " продан");
            } else {
                System.out.println("Неизвестный букет: " + item.name);
            }
        }
    }

    public static void setStatus(String name, String status) {
        Bouquet item = BouquetStore.ITEMS.get(name);
        if (item == null) {
            throw new IllegalArgumentException("не найдено: " + name);
        }
        item.status = status;
        new Notifier().send(name, "Статус: " + status);
    }

    public static void printAll() {
        for (Bouquet item : BouquetStore.ITEMS.values()) {
            System.out.println(item.name + " (" + item.kind + "), " + item.price + ", " + item.status);
        }
    }

    public static int count() {
        return BouquetStore.ITEMS.size();
    }

    public static Bouquet find(String name) {
        return BouquetStore.ITEMS.get(name);
    }
}
