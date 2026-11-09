package ru.ranepa.v21;

public class WaterDelivery {

    private final EmailService emailService = new EmailService();
    private final CsvExporter csvExporter = new CsvExporter();

    public Bottle addBottle(String name, double price, String type) {
        Bottle item;
        if (type.equals("still")) {
            item = new StillBottle(name, price);
        } else if (type.equals("sparkling")) {
            item = new SparklingBottle(name, price);
        } else {
            item = new MineralBottle(name, price);
        }
        Database.BOTTLES.add(item);
        Database.BY_NAME.put(name, item);
        emailService.send(name, "Бутыль добавлена");
        csvExporter.export("item;" + name + ";" + price);
        return item;
    }

    public void addWorker(ShiftWorker worker) {
        Database.WORKERS.add(worker);
    }

    public void deliverAll() {
        for (Bottle item : Database.BOTTLES) {
            item.deliver();
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
        worker.handle(Database.BOTTLES.get(0));
    }

    public double averagePrice() {
        double sum = 0;
        for (Bottle item : Database.BOTTLES) {
            sum += item.price;
        }
        return Database.BOTTLES.isEmpty() ? 0.0 : sum / Database.BOTTLES.size();
    }

    public void printReport() {
        ReportPrinter printer = new ReportPrinter();
        for (Bottle item : Database.BOTTLES) {
            printer.print(item);
        }
        for (ShiftWorker worker : Database.WORKERS) {
            System.out.println(worker.report());
        }
    }

    public void printStatistics() {
        int count = Database.BOTTLES.size();
        int known = 0;
        for (Bottle item : Database.BOTTLES) {
            if (item instanceof StillBottle || item instanceof SparklingBottle) {
                known++;
            }
        }
        System.out.println("Позиций: " + count + ", известных типов: " + known
                + ", средняя цена: " + averagePrice());
    }

    public Bottle findByName(String name) {
        return Database.BY_NAME.get(name);
    }

    public void exportCsv() {
        for (Bottle item : Database.BOTTLES) {
            csvExporter.export(item.role() + ";" + item.name + ";" + item.price);
        }
    }

    public void notifyEveryone(String message) {
        for (ShiftWorker worker : Database.WORKERS) {
            emailService.send(worker.name(), message);
        }
    }
}
