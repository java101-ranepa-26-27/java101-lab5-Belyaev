package ru.ranepa.v16;

public class Main {

    public static void main(String[] args) {
        DrivingSchoolWorkflow workflow = new DrivingSchoolWorkflow();

        workflow.create("sedan", "Седан", 1500);
        workflow.create("hatch", "Хэтчбек", 1400);
        workflow.create("truck", "Грузовик", 2500);
        workflow.addActor(new Instructor("Вадим"));
        workflow.addActor(new Bot("Лариса"));

        workflow.printQueue();
        System.out.println("Итого: " + workflow.total());

        workflow.addExisting(new ArchivedTrainingCar("Сломанный седан", 0));
        try {
            workflow.processAll();
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой обработки: " + e.getMessage());
        }

        try {
            workflow.escalate("Вадим", "Седан");
        } catch (UnsupportedOperationException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        workflow.create("sedan", "Седан", 1550);
        System.out.println("Заявок в HashMap: " + workflow.count());

        System.out.println("Порядок обхода HashMap:");
        for (String name : workflow.names()) {
            System.out.println(name + " -> " + workflow.find(name).getPrice());
        }

        workflow.printQueue();
        workflow.closeDay("Завтра экзамен");
    }
}
