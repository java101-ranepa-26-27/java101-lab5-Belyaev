package ru.ranepa.v10;

public class Main {

    public static void main(String[] args) {
        CampingSystem system = CampingSystem.getInstance();

        system.book("1", "Палатка у леса", CampingSpotKind.TENT, 500);
        system.book("2", "Автодом", CampingSpotKind.CARAVAN, 1200);
        system.book("3", "Глэмпинг", CampingSpotKind.GLAMPING, 3000);
        system.addStaff(new Ranger("Глеб"));
        system.addStaff(new Manager("Вера"));

        system.printQueue();
        System.out.println("Итого: " + system.total());

        system.addRecord(new CancelledCampingSpot("0", "Затопленная палатка", CampingSpotKind.TENT, 0));
        try {
            system.confirmAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой подтверждения: " + e.getMessage());
        }

        try {
            system.cancelByStaff("Вера", "Палатка у леса");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        system.book("4", "Палатка у леса", CampingSpotKind.TENT, 550);
        System.out.println("Записей в HashMap: " + system.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : system.names()) {
            System.out.println(name + " -> " + system.find(name).kind);
        }

        system.printQueue();
        system.closeDay();
    }
}
