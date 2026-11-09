package ru.ranepa.v02;

public class Main {

    public static void main(String[] args) {
        BikeRentalSystem system = BikeRentalSystem.getInstance();

        system.book("1", "Городской", BikeKind.CITY, 500);
        system.book("2", "Горный", BikeKind.MOUNTAIN, 800);
        system.book("3", "Детский", BikeKind.KIDS, 300);
        system.addStaff(new Mechanic("Павел"));
        system.addStaff(new Manager("Ольга"));

        system.printQueue();
        System.out.println("Итого: " + system.total());

        system.addRecord(new CancelledBike("0", "Сломанный велосипед", BikeKind.CITY, 0));
        try {
            system.confirmAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой подтверждения: " + e.getMessage());
        }

        try {
            system.cancelByStaff("Ольга", "Городской");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        system.book("4", "Городской", BikeKind.CITY, 550);
        System.out.println("Записей в HashMap: " + system.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : system.names()) {
            System.out.println(name + " -> " + system.find(name).kind);
        }

        system.printQueue();
        system.closeDay();
    }
}
