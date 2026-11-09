package ru.ranepa.v12;

public class Main {

    public static void main(String[] args) {
        BreweryWorkflow workflow = new BreweryWorkflow();

        workflow.create("lager", "Лагер", 120);
        workflow.create("ale", "Эль", 140);
        workflow.create("stout", "Стаут", 160);
        workflow.addActor(new Brewer("Матвей"));
        workflow.addActor(new Bot("Екатерина"));

        workflow.printQueue();
        System.out.println("Итого: " + workflow.total());

        workflow.addExisting(new ArchivedBeerBatch("Скисшая партия", 0));
        try {
            workflow.processAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой обработки: " + e.getMessage());
        }

        try {
            workflow.escalate("Матвей", "Лагер");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        workflow.create("lager", "Лагер", 170);
        System.out.println("Заявок в HashMap: " + workflow.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : workflow.names()) {
            System.out.println(name + " -> " + workflow.find(name).getPrice());
        }

        workflow.printQueue();
        workflow.closeDay("Завтра дегустация");
    }
}
