package ru.ranepa.v07;

public class Main {

    public static void main(String[] args) {
        InstrumentUtils.create("Пианино", "piano", 1000);
        InstrumentUtils.create("Гитара", "guitar", 700);
        InstrumentUtils.create("Скрипка", "violin", 900);
        InstrumentUtils.create("Пианино", "piano", 1050);
        InstrumentUtils.create("Расстроенное пианино", "piano", 0);

        System.out.println("Объектов в HashMap: " + InstrumentUtils.count());
        InstrumentUtils.printAll();
        InstrumentUtils.processAll();

        InstrumentUtils.setStatus("Расстроенное пианино", "отменён");

        Employee[] employees = {
                new Clerk("Наталья"),
                new Supervisor("Виктор"),
                new Trainee("Стажёр")
        };
        for (Employee employee : employees) {
            try {
                employee.work();
            } catch (UnsupportedOperationException e) {
                System.out.println("Сбой сотрудника: " + e.getMessage());
            }
        }

        Actor supervisor = new Supervisor("Виктор");
        try {
            supervisor.serve(InstrumentUtils.find("Пианино"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        InstrumentUtils.printAll();
    }
}
