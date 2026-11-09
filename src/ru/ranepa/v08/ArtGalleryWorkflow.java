package ru.ranepa.v08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArtGalleryWorkflow {

    private final Map<String, Exhibit> tickets = new HashMap<>();
    private final List<Actor> actors = new ArrayList<>();

    public Exhibit create(String type, String name, double price) {
        Exhibit item;
        if (type.equals("painting")) {
            item = new BasicExhibit(name, price);
        } else if (type.equals("sculpture")) {
            item = new PremiumExhibit(name, price);
        } else {
            item = new BasicExhibit(name, price);
        }
        tickets.put(name, item);
        ServiceLocator.email().send(name, "Экспонат добавлен");
        ServiceLocator.audit().write("create;" + name + ";" + type);
        return item;
    }

    public void addExisting(Exhibit item) {
        tickets.put(item.getName(), item);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void processAll() {
        for (Exhibit item : tickets.values()) {
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
        for (Exhibit item : tickets.values()) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void printQueue() {
        for (Exhibit item : tickets.values()) {
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

    public Exhibit find(String name) {
        return tickets.get(name);
    }

    public void closeDay(String message) {
        for (Exhibit item : tickets.values()) {
            ServiceLocator.audit().write("close;" + item.getName());
        }
        for (Actor actor : actors) {
            ServiceLocator.email().send(actor.name(), message);
        }
    }
}
