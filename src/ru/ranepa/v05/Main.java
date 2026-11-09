package ru.ranepa.v05;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Laundry service = new Laundry();

        service.addLaundryItem("Рубашка", 300, "shirt");
        service.addLaundryItem("Пальто", 900, "coat");
        service.addLaundryItem("Одеяло", 600, "blanket");
        service.addWorker(new Washer("Татьяна", 40000));
        service.addWorker(new Manager("Андрей", 60000));

        service.printReport();
        service.printStatistics();

        Database.ITEMS.add(new DelicateShirt("Шёлковая рубашка", 500));
        try {
            service.washAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой операции: " + e.getMessage());
        }

        try {
            service.handleByWorker("Андрей");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        service.addLaundryItem("Рубашка", 350, "shirt");
        System.out.println("Объектов в списке: " + Database.ITEMS.size());
        System.out.println("Объектов в HashMap: " + Database.BY_NAME.size());

        System.out.println("Порядок обхода HashMap:");
        for (Map.Entry<String, LaundryItem> entry : Database.BY_NAME.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().role());
        }

        service.exportCsv();
        service.notifyEveryone("Завтра доставка белья");
    }
}
