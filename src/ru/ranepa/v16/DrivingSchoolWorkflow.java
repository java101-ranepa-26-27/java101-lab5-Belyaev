package ru.ranepa.v16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DrivingSchoolWorkflow {

    private final Map<String, TrainingCar> tickets = new HashMap<>();
    private final List<Actor> actors = new ArrayList<>();

    public TrainingCar create(String type, String name, double price) {
        TrainingCar item;
        if (type.equals("sedan")) {
            item = new BasicTrainingCar(name, price);
        } else if (type.equals("hatch")) {
            item = new PremiumTrainingCar(name, price);
        } else {
            item = new BasicTrainingCar(name, price);
        }
        tickets.put(name, item);
        ServiceLocator.email().send(name, "Автомобиль добавлен");
        ServiceLocator.audit().write("create;" + name + ";" + type);
        return item;
    }

    public void addExisting(TrainingCar item) {
        tickets.put(item.getName(), item);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void processAll() {
        for (TrainingCar item : tickets.values()) {
            item.process();
        }
    }

    public void escalate(String actorName, String itemName) {
        Actor actor = null;
        for (Actor candidate : actors) {
            if (candidate.name().equals(actorName)) {
                actor = candidate;
            }
        }
        if (actor == null) {
            throw new IllegalArgumentException("исполнитель не найден: " + actorName);
        }
        actor.escalate(tickets.get(itemName));
    }

    public double total() {
        double sum = 0;
        for (TrainingCar item : tickets.values()) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void printQueue() {
        for (TrainingCar item : tickets.values()) {
            System.out.println(item.getName() + " " + item.getPrice());
        }
        for (Actor actor : actors) {
            System.out.println("Исполнитель: " + actor.name());
        }
    }

    public int count() {
        return tickets.size();
    }

    public Set<String> names() {
        return tickets.keySet();
    }

    public TrainingCar find(String name) {
        return tickets.get(name);
    }

    public void closeDay(String message) {
        for (TrainingCar item : tickets.values()) {
            ServiceLocator.audit().write("close;" + item.getName());
        }
        for (Actor actor : actors) {
            ServiceLocator.email().send(actor.name(), message);
        }
    }
}
