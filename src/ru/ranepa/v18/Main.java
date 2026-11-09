package ru.ranepa.v18;

public class Main {

    public static void main(String[] args) {
        DanceStudioSystem system = DanceStudioSystem.getInstance();

        system.book("1", "Сальса", DanceClassKind.SALSA, 800);
        system.book("2", "Балет", DanceClassKind.BALLET, 1000);
        system.book("3", "Хип-хоп", DanceClassKind.HIPHOP, 900);
        system.addStaff(new Choreographer("Диана"));
        system.addStaff(new Manager("Аркадий"));

        system.printQueue();
        System.out.println("Итого: " + system.total());

        system.addRecord(new CancelledDanceClass("0", "Отменённая сальса", DanceClassKind.SALSA, 0));
        try {
            system.confirmAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой подтверждения: " + e.getMessage());
        }

        try {
            system.cancelByStaff("Аркадий", "Сальса");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        system.book("4", "Сальса", DanceClassKind.SALSA, 850);
        System.out.println("Записей в HashMap: " + system.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : system.names()) {
            System.out.println(name + " -> " + system.find(name).kind);
        }

        system.printQueue();
        system.closeDay();
    }
}
