package ru.ranepa.v04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroomingSalonWorkflow {

    private final Map<String, Pet> tickets = new HashMap<>();
    private final List<Actor> actors = new ArrayList<>();

    public Pet create(String type, String name, double price) {
        Pet item;
        if (type.equals("dog")) {
            item = new BasicPet(name, price);
        } else if (type.equals("cat")) {
            item = new PremiumPet(name, price);
        } else {
            item = new BasicPet(name, price);
        }
        tickets.put(name, item);
        ServiceLocator.email().send(name, "Питомец добавлен");
        ServiceLocator.audit().write("create;" + name + ";" + type);
        return item;
    }

    public void addExisting(Pet item) {
        tickets.put(item.getName(), item);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void processAll() {
        for (Pet item : tickets.values()) {
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
        for (Pet item : tickets.values()) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void printQueue() {
        for (Pet item : tickets.values()) {
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

    public Pet find(String name) {
        return tickets.get(name);
    }

    public void closeDay(String message) {
        for (Pet item : tickets.values()) {
            ServiceLocator.audit().write("close;" + item.getName());
        }
        for (Actor actor : actors) {
            ServiceLocator.email().send(actor.name(), message);
        }
    }
}
