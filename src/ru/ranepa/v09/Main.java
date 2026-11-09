package ru.ranepa.v09;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        BowlingClub service = new BowlingClub();

        service.addLane("Дорожка 1", 600, "standard");
        service.addLane("VIP", 1500, "vip");
        service.addLane("Детская", 400, "kids");
        service.addWorker(new Instructor("Кирилл", 40000));
        service.addWorker(new Manager("Светлана", 60000));

        service.printReport();
        service.printStatistics();

        Database.LANES.add(new BrokenLane("Сломанная дорожка", 0));
        try {
            service.playAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой операции: " + e.getMessage());
        }

        try {
            service.handleByWorker("Светлана");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        service.addLane("Дорожка 1", 650, "standard");
        System.out.println("Объектов в списке: " + Database.LANES.size());
        System.out.println("Объектов в HashMap: " + Database.BY_NAME.size());

        System.out.println("Порядок обхода HashMap:");
        for (Map.Entry<String, Lane> entry : Database.BY_NAME.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().role());
        }

        service.exportCsv();
        service.notifyEveryone("Завтра турнир");
    }
}
