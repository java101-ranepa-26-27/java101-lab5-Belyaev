package ru.ranepa.v03;

public class Main {

    public static void main(String[] args) {
        BouquetUtils.create("Розы", "rose", 1500);
        BouquetUtils.create("Тюльпаны", "tulip", 1200);
        BouquetUtils.create("Микс", "mixed", 2000);
        BouquetUtils.create("Розы", "rose", 1550);
        BouquetUtils.create("Увядший букет", "rose", 100);

        System.out.println("Объектов в HashMap: " + BouquetUtils.count());
        BouquetUtils.printAll();
        BouquetUtils.processAll();

        BouquetUtils.setStatus("Увядший букет", "отменён");

        Employee[] employees = {
                new Clerk("Мария"),
                new Supervisor("Сергей"),
                new Trainee("Стажёр")
        };
        for (Employee employee : employees) {
            try {
                employee.work();
            } catch (UnsupportedOperationException e) {
                System.out.println("Сбой сотрудника: " + e.getMessage());
            }
        }

        Actor supervisor = new Supervisor("Сергей");
        try {
            supervisor.serve(BouquetUtils.find("Розы"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        BouquetUtils.printAll();
    }
}
