package ru.ranepa.v06;

public class Main {

    public static void main(String[] args) {
        CoworkingSystem system = CoworkingSystem.getInstance();

        system.book("1", "Стол у окна", WorkspaceKind.DESK, 800);
        system.book("2", "Переговорная", WorkspaceKind.MEETING, 3000);
        system.book("3", "Тихая комната", WorkspaceKind.QUIET, 1500);
        system.addStaff(new Administrator("Ирина"));
        system.addStaff(new Manager("Максим"));

        system.printQueue();
        System.out.println("Итого: " + system.total());

        system.addRecord(new CancelledWorkspace("0", "Сломанный стол", WorkspaceKind.DESK, 0));
        try {
            system.confirmAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой подтверждения: " + e.getMessage());
        }

        try {
            system.cancelByStaff("Максим", "Стол у окна");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        system.book("4", "Стол у окна", WorkspaceKind.DESK, 850);
        System.out.println("Записей в HashMap: " + system.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : system.names()) {
            System.out.println(name + " -> " + system.find(name).kind);
        }

        system.printQueue();
        system.closeDay();
    }
}
