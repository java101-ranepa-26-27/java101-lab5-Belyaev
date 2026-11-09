package ru.ranepa.v05;

public class Laundry {

    private final EmailService emailService = new EmailService();
    private final CsvExporter csvExporter = new CsvExporter();

    public LaundryItem addLaundryItem(String name, double price, String type) {
        LaundryItem item;
        if (type.equals("shirt")) {
            item = new Shirt(name, price);
        } else if (type.equals("coat")) {
            item = new Coat(name, price);
        } else {
            item = new Blanket(name, price);
        }
        Database.ITEMS.add(item);
        Database.BY_NAME.put(name, item);
        emailService.send(name, "Изделие принято");
        csvExporter.export("item;" + name + ";" + price);
        return item;
    }

    public void addWorker(ShiftWorker worker) {
        Database.WORKERS.add(worker);
    }

    public void washAll() {
        for (LaundryItem item : Database.ITEMS) {
            item.wash();
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
        worker.handle(Database.ITEMS.get(0));
    }

    public double averagePrice() {
        double sum = 0;
        for (LaundryItem item : Database.ITEMS) {
            sum += item.price;
        }
        return Database.ITEMS.isEmpty() ? 0.0 : sum / Database.ITEMS.size();
    }

    public void printReport() {
        ReportPrinter printer = new ReportPrinter();
        for (LaundryItem item : Database.ITEMS) {
            printer.print(item);
        }
        for (ShiftWorker worker : Database.WORKERS) {
            System.out.println(worker.report());
        }
    }

    public void printStatistics() {
        int count = Database.ITEMS.size();
        int known = 0;
        for (LaundryItem item : Database.ITEMS) {
            if (item instanceof Shirt || item instanceof Coat) {
                known++;
            }
        }
        System.out.println("Позиций: " + count + ", известных типов: " + known
                + ", средняя цена: " + averagePrice());
    }

    public LaundryItem findByName(String name) {
        return Database.BY_NAME.get(name);
    }

    public void exportCsv() {
        for (LaundryItem item : Database.ITEMS) {
            csvExporter.export(item.role() + ";" + item.name + ";" + item.price);
        }
    }

    public void notifyEveryone(String message) {
        for (ShiftWorker worker : Database.WORKERS) {
            emailService.send(worker.name(), message);
        }
    }
}
