package ru.ranepa.v04;

public class Main {

    public static void main(String[] args) {
        GroomingSalonWorkflow workflow = new GroomingSalonWorkflow();

        workflow.create("dog", "Бобик", 2500);
        workflow.create("cat", "Мурка", 1800);
        workflow.create("rabbit", "Снежок", 1500);
        workflow.addActor(new Groomer("Елена"));
        workflow.addActor(new Bot("Дмитрий"));

        workflow.printQueue();
        System.out.println("Итого: " + workflow.total());

        workflow.addExisting(new ArchivedPet("Агрессивная собака", 0));
        try {
            workflow.processAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой обработки: " + e.getMessage());
        }

        try {
            workflow.escalate("Елена", "Бобик");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        workflow.create("dog", "Бобик", 2550);
        System.out.println("Заявок в HashMap: " + workflow.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : workflow.names()) {
            System.out.println(name + " -> " + workflow.find(name).getPrice());
        }

        workflow.printQueue();
        workflow.closeDay("Завтра санитарный день");
    }
}
