package ru.ranepa.v17;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        LanguageSchool service = new LanguageSchool();

        service.addCourse("Английский", 12000, "english");
        service.addCourse("Немецкий", 11000, "german");
        service.addCourse("Французский", 11500, "french");
        service.addWorker(new Teacher("Ксения", 40000));
        service.addWorker(new Manager("Юрий", 60000));

        service.printReport();
        service.printStatistics();

        Database.COURSES.add(new CancelledEnglishCourse("Отменённый английский", 0));
        try {
            service.startAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой операции: " + e.getMessage());
        }

        try {
            service.handleByWorker("Юрий");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        service.addCourse("Английский", 12050, "english");
        System.out.println("Объектов в списке: " + Database.COURSES.size());
        System.out.println("Объектов в HashMap: " + Database.BY_NAME.size());

        System.out.println("Порядок обхода HashMap:");
        for (Map.Entry<String, Course> entry : Database.BY_NAME.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().role());
        }

        service.exportCsv();
        service.notifyEveryone("Завтра родительское собрание");
    }
}
