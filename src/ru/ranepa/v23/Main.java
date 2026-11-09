package ru.ranepa.v23;

public class Main {

    public static void main(String[] args) {
        BakeryItemUtils.create("Белый", "white", 80);
        BakeryItemUtils.create("Ржаной", "rye", 90);
        BakeryItemUtils.create("Круассан", "croissant", 120);
        BakeryItemUtils.create("Белый", "white", 130);
        BakeryItemUtils.create("Сгоревший хлеб", "white", 0);

        System.out.println("Объектов в HashMap: " + BakeryItemUtils.count());
        BakeryItemUtils.printAll();
        BakeryItemUtils.processAll();

        BakeryItemUtils.setStatus("Сгоревший хлеб", "отменён");

        Employee[] employees = {
                new Clerk("Фёдор"),
                new Supervisor("Зоя"),
                new Trainee("Стажёр")
        };
        for (Employee employee : employees) {
            try {
                employee.work();
            } catch (UnsupportedOperationException e) {
                System.out.println("Сбой сотрудника: " + e.getMessage());
            }
        }

        Actor supervisor = new Supervisor("Зоя");
        try {
            supervisor.serve(BakeryItemUtils.find("Белый"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        BakeryItemUtils.printAll();
    }
}
