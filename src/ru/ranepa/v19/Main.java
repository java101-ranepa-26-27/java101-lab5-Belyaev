package ru.ranepa.v19;

public class Main {

    public static void main(String[] args) {
        ShootUtils.create("Портрет", "portrait", 3000);
        ShootUtils.create("Свадьба", "wedding", 15000);
        ShootUtils.create("Предметная", "product", 5000);
        ShootUtils.create("Портрет", "portrait", 3050);
        ShootUtils.create("Отменённый портрет", "portrait", 0);

        System.out.println("Объектов в HashMap: " + ShootUtils.count());
        ShootUtils.printAll();
        ShootUtils.processAll();

        ShootUtils.setStatus("Отменённый портрет", "отменён");

        Employee[] employees = {
                new Clerk("Лилия"),
                new Supervisor("Станислав"),
                new Trainee("Стажёр")
        };
        for (Employee employee : employees) {
            try {
                employee.work();
            } catch (UnsupportedOperationException e) {
                System.out.println("Сбой сотрудника: " + e.getMessage());
            }
        }

        Actor supervisor = new Supervisor("Станислав");
        try {
            supervisor.serve(ShootUtils.find("Портрет"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        ShootUtils.printAll();
    }
}
