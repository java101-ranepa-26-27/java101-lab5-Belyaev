package ru.ranepa.v22;

public class Main {

    public static void main(String[] args) {
        BoardGameShopSystem system = BoardGameShopSystem.getInstance();

        system.book("1", "Стратегия", BoardGameKind.STRATEGY, 3000);
        system.book("2", "Вечеринка", BoardGameKind.PARTY, 1500);
        system.book("3", "Семейная", BoardGameKind.FAMILY, 2000);
        system.addStaff(new Consultant("Марк"));
        system.addStaff(new Manager("Жанна"));

        system.printQueue();
        System.out.println("Итого: " + system.total());

        system.addRecord(new CancelledBoardGame("0", "Неукомплектованная стратегия", BoardGameKind.STRATEGY, 0));
        try {
            system.confirmAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой подтверждения: " + e.getMessage());
        }

        try {
            system.cancelByStaff("Жанна", "Стратегия");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        system.book("4", "Стратегия", BoardGameKind.STRATEGY, 3050);
        System.out.println("Записей в HashMap: " + system.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : system.names()) {
            System.out.println(name + " -> " + system.find(name).kind);
        }

        system.printQueue();
        system.closeDay();
    }
}
