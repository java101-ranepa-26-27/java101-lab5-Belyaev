package ru.ranepa.v01;

public class CoffeeShop {

    private final EmailService emailService = new EmailService();
    private final CsvExporter csvExporter = new CsvExporter();

    public Drink addDrink(String name, double price, String type) {
        Drink item;
        if (type.equals("coffee")) {
            item = new Coffee(name, price);
        } else if (type.equals("tea")) {
            item = new Tea(name, price);
        } else {
            item = new Cocoa(name, price);
        }
        Database.DRINKS.add(item);
        Database.BY_NAME.put(name, item);
        emailService.send(name, "Напиток добавлен");
        csvExporter.export("item;" + name + ";" + price);
        return item;
    }

    public void addWorker(ShiftWorker worker) {
        Database.WORKERS.add(worker);
    }

    public void brewAll() {
        for (Drink item : Database.DRINKS) {
            item.brew();
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
        worker.handle(Database.DRINKS.get(0));
    }

    public double averagePrice() {
        double sum = 0;
        for (Drink item : Database.DRINKS) {
            sum += item.price;
        }
        return Database.DRINKS.isEmpty() ? 0.0 : sum / Database.DRINKS.size();
    }

    public void printReport() {
        ReportPrinter printer = new ReportPrinter();
        for (Drink item : Database.DRINKS) {
            printer.print(item);
        }
        for (ShiftWorker worker : Database.WORKERS) {
            System.out.println(worker.report());
        }
    }

    public void printStatistics() {
        int count = Database.DRINKS.size();
        int known = 0;
        for (Drink item : Database.DRINKS) {
            if (item instanceof Coffee || item instanceof Tea) {
                known++;
            }
        }
        System.out.println("Позиций: " + count + ", известных типов: " + known
                + ", средняя цена: " + averagePrice());
    }

    public Drink findByName(String name) {
        return Database.BY_NAME.get(name);
    }

    public void exportCsv() {
        for (Drink item : Database.DRINKS) {
            csvExporter.export(item.role() + ";" + item.name + ";" + item.price);
        }
    }

    public void notifyEveryone(String message) {
        for (ShiftWorker worker : Database.WORKERS) {
            emailService.send(worker.name(), message);
        }
    }
}
