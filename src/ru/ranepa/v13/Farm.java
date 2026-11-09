package ru.ranepa.v13;

public class Farm {

    private final EmailService emailService = new EmailService();
    private final CsvExporter csvExporter = new CsvExporter();

    public Animal addAnimal(String name, double price, String type) {
        Animal item;
        if (type.equals("cow")) {
            item = new Cow(name, price);
        } else if (type.equals("chicken")) {
            item = new Chicken(name, price);
        } else {
            item = new Goat(name, price);
        }
        Database.ANIMALS.add(item);
        Database.BY_NAME.put(name, item);
        emailService.send(name, "Животное добавлено");
        csvExporter.export("item;" + name + ";" + price);
        return item;
    }

    public void addWorker(ShiftWorker worker) {
        Database.WORKERS.add(worker);
    }

    public void produceAll() {
        for (Animal item : Database.ANIMALS) {
            item.produce();
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
        worker.handle(Database.ANIMALS.get(0));
    }

    public double averagePrice() {
        double sum = 0;
        for (Animal item : Database.ANIMALS) {
            sum += item.price;
        }
        return Database.ANIMALS.isEmpty() ? 0.0 : sum / Database.ANIMALS.size();
    }

    public void printReport() {
        ReportPrinter printer = new ReportPrinter();
        for (Animal item : Database.ANIMALS) {
            printer.print(item);
        }
        for (ShiftWorker worker : Database.WORKERS) {
            System.out.println(worker.report());
        }
    }

    public void printStatistics() {
        int count = Database.ANIMALS.size();
        int known = 0;
        for (Animal item : Database.ANIMALS) {
            if (item instanceof Cow || item instanceof Chicken) {
                known++;
            }
        }
        System.out.println("Позиций: " + count + ", известных типов: " + known
                + ", средняя цена: " + averagePrice());
    }

    public Animal findByName(String name) {
        return Database.BY_NAME.get(name);
    }

    public void exportCsv() {
        for (Animal item : Database.ANIMALS) {
            csvExporter.export(item.role() + ";" + item.name + ";" + item.price);
        }
    }

    public void notifyEveryone(String message) {
        for (ShiftWorker worker : Database.WORKERS) {
            emailService.send(worker.name(), message);
        }
    }
}
