package ru.ranepa.v01;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        CoffeeShop service = new CoffeeShop();

        service.addDrink("Латте", 250, "coffee");
        service.addDrink("Чай", 150, "tea");
        service.addDrink("Какао", 200, "cocoa");
        service.addWorker(new Barista("Анна", 40000));
        service.addWorker(new Manager("Игорь", 60000));

        service.printReport();
        service.printStatistics();

        Database.DRINKS.add(new DecafCoffee("Декаф", 300));
        try {
            service.brewAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой операции: " + e.getMessage());
        }

        try {
            service.handleByWorker("Игорь");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        service.addDrink("Латте", 300, "coffee");
        System.out.println("Объектов в списке: " + Database.DRINKS.size());
        System.out.println("Объектов в HashMap: " + Database.BY_NAME.size());

        System.out.println("Порядок обхода HashMap:");
        for (Map.Entry<String, Drink> entry : Database.BY_NAME.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().role());
        }

        service.exportCsv();
        service.notifyEveryone("Завтра инвентаризация");
    }
}
