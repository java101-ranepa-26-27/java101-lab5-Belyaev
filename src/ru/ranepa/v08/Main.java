package ru.ranepa.v08;

public class Main {

    public static void main(String[] args) {
        ArtGalleryWorkflow workflow = new ArtGalleryWorkflow();

        workflow.create("painting", "Пейзаж", 5000);
        workflow.create("sculpture", "Бюст", 8000);
        workflow.create("photo", "Портрет", 3000);
        workflow.addActor(new Curator("Алина"));
        workflow.addActor(new Bot("Роман"));

        workflow.printQueue();
        System.out.println("Итого: " + workflow.total());

        workflow.addExisting(new ArchivedExhibit("Картина на реставрации", 0));
        try {
            workflow.processAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой обработки: " + e.getMessage());
        }

        try {
            workflow.escalate("Алина", "Пейзаж");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        workflow.create("painting", "Пейзаж", 5050);
        System.out.println("Заявок в HashMap: " + workflow.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : workflow.names()) {
            System.out.println(name + " -> " + workflow.find(name).getPrice());
        }

        workflow.printQueue();
        workflow.closeDay("Завтра открытие выставки");
    }
}
