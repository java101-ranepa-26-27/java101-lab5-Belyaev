package ru.ranepa.v11;

public class Main {

    public static void main(String[] args) {
        PublicationUtils.create("Листовка", "flyer", 5);
        PublicationUtils.create("Книга", "book", 300);
        PublicationUtils.create("Плакат", "poster", 150);
        PublicationUtils.create("Листовка", "flyer", 55);
        PublicationUtils.create("Повреждённая книга", "flyer", 0);

        System.out.println("Объектов в HashMap: " + PublicationUtils.count());
        PublicationUtils.printAll();
        PublicationUtils.processAll();

        PublicationUtils.setStatus("Повреждённая книга", "отменён");

        Employee[] employees = {
                new Clerk("Артём"),
                new Supervisor("Людмила"),
                new Trainee("Стажёр")
        };
        for (Employee employee : employees) {
            try {
                employee.work();
            } catch (UnsupportedOperationException e) {
                System.out.println("Сбой сотрудника: " + e.getMessage());
            }
        }

        Actor supervisor = new Supervisor("Людмила");
        try {
            supervisor.serve(PublicationUtils.find("Листовка"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        PublicationUtils.printAll();
    }
}
