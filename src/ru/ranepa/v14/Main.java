package ru.ranepa.v14;

public class Main {

    public static void main(String[] args) {
        AquariumSystem system = AquariumSystem.getInstance();

        system.book("1", "Акула", SeaCreatureKind.SHARK, 3000);
        system.book("2", "Клоун", SeaCreatureKind.CLOWN, 500);
        system.book("3", "Медуза", SeaCreatureKind.JELLY, 400);
        system.addStaff(new Aquarist("Денис"));
        system.addStaff(new Manager("Полина"));

        system.printQueue();
        System.out.println("Итого: " + system.total());

        system.addRecord(new CancelledSeaCreature("0", "Акула на карантине", SeaCreatureKind.SHARK, 0));
        try {
            system.confirmAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой подтверждения: " + e.getMessage());
        }

        try {
            system.cancelByStaff("Полина", "Акула");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        system.book("4", "Акула", SeaCreatureKind.SHARK, 3050);
        System.out.println("Записей в HashMap: " + system.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : system.names()) {
            System.out.println(name + " -> " + system.find(name).kind);
        }

        system.printQueue();
        system.closeDay();
    }
}
