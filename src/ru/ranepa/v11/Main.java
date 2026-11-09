package ru.ranepa.v11;

import java.util.ArrayList;
import ru.ranepa.v11.application.PublicationUtils;
import ru.ranepa.v11.domain.CanCheck;
import ru.ranepa.v11.domain.Book;
import ru.ranepa.v11.domain.Clerk;
import ru.ranepa.v11.domain.Employee;
import ru.ranepa.v11.domain.Flyer;
import ru.ranepa.v11.domain.Poster;
import ru.ranepa.v11.domain.Supervisor;
import ru.ranepa.v11.domain.Trainee;
import ru.ranepa.v11.infrastructure.Notifier;
import ru.ranepa.v11.infrastructure.Printer;
import ru.ranepa.v11.infrastructure.PublicationStore;

/**
 * Применён принцип инверсии зависимостей (DIP).
 * Объекты хранилища и уведомителя создаются в Main и передаются в PublicationUtils.
 */
public class Main {

    public static void main(String[] args) {
        PublicationUtils shop = new PublicationUtils(new PublicationStore(), new Notifier());
        Printer printer = new Printer();

        shop.create(new Flyer("Листовка", 5));
        shop.create(new Book("Книга", 300));
        shop.create(new Poster("Плакат", 150));
        shop.create(new Flyer("Листовка", 55));
        shop.create(new Flyer("Повреждённая книга", 0));

        System.out.println("Объектов в HashMap: " + shop.count());
        printer.printAll(shop.findAll());
        printer.processAll(shop.findAll());
        shop.setStatus("Повреждённая книга", "отменён");

        Employee[] employees = {
                new Clerk("Артём"),
                new Supervisor("Людмила"),
                new Trainee("Стажёр")
        };
        for (Employee employee : employees) {
            employee.work();
        }
        CanCheck supervisor = new Supervisor("Людмила");
        supervisor.audit(shop.find("Листовка"));
        printer.printAll(shop.findAll());
    }

}
