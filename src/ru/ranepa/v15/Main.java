package ru.ranepa.v15;

public class Main {

    public static void main(String[] args) {
        ShowUtils.create("Звёзды", "star", 600);
        ShowUtils.create("Планеты", "planet", 700);
        ShowUtils.create("Детям", "kids", 400);
        ShowUtils.create("Звёзды", "star", 650);
        ShowUtils.create("Отменённое шоу", "star", 0);

        System.out.println("Объектов в HashMap: " + ShowUtils.count());
        ShowUtils.printAll();
        ShowUtils.processAll();

        ShowUtils.setStatus("Отменённое шоу", "отменён");

        Employee[] employees = {
                new Clerk("Олег"),
                new Supervisor("Надежда"),
                new Trainee("Стажёр")
        };
        for (Employee employee : employees) {
            try {
                employee.work();
            } catch (UnsupportedOperationException e) {
                System.out.println("Сбой сотрудника: " + e.getMessage());
            }
        }

        Actor supervisor = new Supervisor("Надежда");
        try {
            supervisor.serve(ShowUtils.find("Звёзды"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        ShowUtils.printAll();
    }
}
