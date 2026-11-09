package ru.ranepa.v13;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Farm service = new Farm();

        service.addAnimal("Бурёнка", 100, "cow");
        service.addAnimal("Ряба", 20, "chicken");
        service.addAnimal("Зорька", 80, "goat");
        service.addWorker(new Farmer("Николай", 40000));
        service.addWorker(new Manager("Галина", 60000));

        service.printReport();
        service.printStatistics();

        Database.ANIMALS.add(new SickCow("Больная корова", 0));
        try {
            service.produceAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой операции: " + e.getMessage());
        }

        try {
            service.handleByWorker("Галина");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        service.addAnimal("Бурёнка", 150, "cow");
        System.out.println("Объектов в списке: " + Database.ANIMALS.size());
        System.out.println("Объектов в HashMap: " + Database.BY_NAME.size());

        System.out.println("Порядок обхода HashMap:");
        for (Map.Entry<String, Animal> entry : Database.BY_NAME.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().role());
        }

        service.exportCsv();
        service.notifyEveryone("Завтра ветеринар");
    }
}
