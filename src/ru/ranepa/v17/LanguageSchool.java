package ru.ranepa.v17;

public class LanguageSchool {

    private final EmailService emailService = new EmailService();
    private final CsvExporter csvExporter = new CsvExporter();

    public Course addCourse(String name, double price, String type) {
        Course item;
        if (type.equals("english")) {
            item = new EnglishCourse(name, price);
        } else if (type.equals("german")) {
            item = new GermanCourse(name, price);
        } else {
            item = new FrenchCourse(name, price);
        }
        Database.COURSES.add(item);
        Database.BY_NAME.put(name, item);
        emailService.send(name, "Курс добавлен");
        csvExporter.export("item;" + name + ";" + price);
        return item;
    }

    public void addWorker(ShiftWorker worker) {
        Database.WORKERS.add(worker);
    }

    public void startAll() {
        for (Course item : Database.COURSES) {
            item.start();
        }
    }

    public void handleByWorker(String workerName) {
        ShiftWorker worker = null;
        for (ShiftWorker candidate : Database.WORKERS) {
            if (candidate.name().equals(workerName)) {
                worker = candidate;
            }
        }
        if (worker == null) {
            throw new IllegalArgumentException("сотрудник не найден: " + workerName);
        }
        worker.handle(Database.COURSES.get(0));
    }

    public double averagePrice() {
        double sum = 0;
        for (Course item : Database.COURSES) {
            sum += item.price;
        }
        return Database.COURSES.isEmpty() ? 0.0 : sum / Database.COURSES.size();
    }

    public void printReport() {
        ReportPrinter printer = new ReportPrinter();
        for (Course item : Database.COURSES) {
            printer.print(item);
        }
        for (ShiftWorker worker : Database.WORKERS) {
            System.out.println(worker.report());
        }
    }

    public void printStatistics() {
        int count = Database.COURSES.size();
        int known = 0;
        for (Course item : Database.COURSES) {
            if (item instanceof EnglishCourse || item instanceof GermanCourse) {
                known++;
            }
        }
        System.out.println("Позиций: " + count + ", известных типов: " + known
                + ", средняя цена: " + averagePrice());
    }

    public Course findByName(String name) {
        return Database.BY_NAME.get(name);
    }

    public void exportCsv() {
        for (Course item : Database.COURSES) {
            csvExporter.export(item.role() + ";" + item.name + ";" + item.price);
        }
    }

    public void notifyEveryone(String message) {
        for (ShiftWorker worker : Database.WORKERS) {
            emailService.send(worker.name(), message);
        }
    }
}
