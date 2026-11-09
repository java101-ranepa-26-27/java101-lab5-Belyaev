package ru.ranepa.v21;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        WaterDelivery service = new WaterDelivery();

        service.addBottle("Без газа", 300, "still");
        service.addBottle("С газом", 350, "sparkling");
        service.addBottle("Минеральная", 500, "mineral");
        service.addWorker(new Courier("Руслан", 40000));
        service.addWorker(new Manager("Инна", 60000));

        service.printReport();
        service.printStatistics();

        Database.BOTTLES.add(new LeakingBottle("Протекающая бутыль", 0));
        try {
            service.deliverAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой операции: " + e.getMessage());
        }

        try {
            service.handleByWorker("Инна");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        service.addBottle("Без газа", 350, "still");
        System.out.println("Объектов в списке: " + Database.BOTTLES.size());
        System.out.println("Объектов в HashMap: " + Database.BY_NAME.size());

        System.out.println("Порядок обхода HashMap:");
        for (Map.Entry<String, Bottle> entry : Database.BY_NAME.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().role());
        }

        service.exportCsv();
        service.notifyEveryone("Завтра новый маршрут");
    }
}
