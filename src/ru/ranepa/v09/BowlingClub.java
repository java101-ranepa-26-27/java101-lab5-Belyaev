package ru.ranepa.v09;

public class BowlingClub {

    private final EmailService emailService = new EmailService();
    private final CsvExporter csvExporter = new CsvExporter();

    public Lane addLane(String name, double price, String type) {
        Lane item;
        if (type.equals("standard")) {
            item = new StandardLane(name, price);
        } else if (type.equals("vip")) {
            item = new VIPLane(name, price);
        } else {
            item = new KidsLane(name, price);
        }
        Database.LANES.add(item);
        Database.BY_NAME.put(name, item);
        emailService.send(name, "Дорожка добавлена");
        csvExporter.export("item;" + name + ";" + price);
        return item;
    }

    public void addWorker(ShiftWorker worker) {
        Database.WORKERS.add(worker);
    }

    public void playAll() {
        for (Lane item : Database.LANES) {
            item.play();
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
        worker.handle(Database.LANES.get(0));
    }

    public double averagePrice() {
        double sum = 0;
        for (Lane item : Database.LANES) {
            sum += item.price;
        }
        return Database.LANES.isEmpty() ? 0.0 : sum / Database.LANES.size();
    }

    public void printReport() {
        ReportPrinter printer = new ReportPrinter();
        for (Lane item : Database.LANES) {
            printer.print(item);
        }
        for (ShiftWorker worker : Database.WORKERS) {
            System.out.println(worker.report());
        }
    }

    public void printStatistics() {
        int count = Database.LANES.size();
        int known = 0;
        for (Lane item : Database.LANES) {
            if (item instanceof StandardLane || item instanceof VIPLane) {
                known++;
            }
        }
        System.out.println("Позиций: " + count + ", известных типов: " + known
                + ", средняя цена: " + averagePrice());
    }

    public Lane findByName(String name) {
        return Database.BY_NAME.get(name);
    }

    public void exportCsv() {
        for (Lane item : Database.LANES) {
            csvExporter.export(item.role() + ";" + item.name + ";" + item.price);
        }
    }

    public void notifyEveryone(String message) {
        for (ShiftWorker worker : Database.WORKERS) {
            emailService.send(worker.name(), message);
        }
    }
}
