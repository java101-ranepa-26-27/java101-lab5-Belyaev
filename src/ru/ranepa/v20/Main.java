package ru.ranepa.v20;

public class Main {

    public static void main(String[] args) {
        RepairShopWorkflow workflow = new RepairShopWorkflow();

        workflow.create("phone", "Телефон", 2000);
        workflow.create("laptop", "Ноутбук", 5000);
        workflow.create("tablet", "Планшет", 3000);
        workflow.addActor(new Technician("Пётр"));
        workflow.addActor(new Bot("Алла"));

        workflow.printQueue();
        System.out.println("Итого: " + workflow.total());

        workflow.addExisting(new ArchivedDevice("Утопленный телефон", 0));
        try {
            workflow.processAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой обработки: " + e.getMessage());
        }

        try {
            workflow.escalate("Пётр", "Телефон");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        workflow.create("phone", "Телефон", 2050);
        System.out.println("Заявок в HashMap: " + workflow.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : workflow.names()) {
            System.out.println(name + " -> " + workflow.find(name).getPrice());
        }

        workflow.printQueue();
        workflow.closeDay("Завтра завоз запчастей");
    }
}
