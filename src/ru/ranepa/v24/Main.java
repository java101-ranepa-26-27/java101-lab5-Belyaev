package ru.ranepa.v24;

public class Main {

    public static void main(String[] args) {
        TattooStudioWorkflow workflow = new TattooStudioWorkflow();

        workflow.create("small", "Маленькая", 5000);
        workflow.create("sleeve", "Рукав", 30000);
        workflow.create("cover", "Перекрытие", 15000);
        workflow.addActor(new TattooArtist("Влад"));
        workflow.addActor(new Bot("Эльвира"));

        workflow.printQueue();
        System.out.println("Итого: " + workflow.total());

        workflow.addExisting(new ArchivedTattoo("Татуировка при аллергии", 0));
        try {
            workflow.processAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой обработки: " + e.getMessage());
        }

        try {
            workflow.escalate("Влад", "Маленькая");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        workflow.create("small", "Маленькая", 5050);
        System.out.println("Заявок в HashMap: " + workflow.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : workflow.names()) {
            System.out.println(name + " -> " + workflow.find(name).getPrice());
        }

        workflow.printQueue();
        workflow.closeDay("Завтра санитарный день");
    }
}
