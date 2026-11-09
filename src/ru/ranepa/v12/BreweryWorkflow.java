package ru.ranepa.v12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BreweryWorkflow {

    private final Map<String, BeerBatch> tickets = new HashMap<>();
    private final List<Actor> actors = new ArrayList<>();

    public BeerBatch create(String type, String name, double price) {
        BeerBatch item;
        if (type.equals("lager")) {
            item = new BasicBeerBatch(name, price);
        } else if (type.equals("ale")) {
            item = new PremiumBeerBatch(name, price);
        } else {
            item = new BasicBeerBatch(name, price);
        }
        tickets.put(name, item);
        ServiceLocator.email().send(name, "Партия добавлена");
        ServiceLocator.audit().write("create;" + name + ";" + type);
        return item;
    }

    public void addExisting(BeerBatch item) {
        tickets.put(item.getName(), item);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void processAll() {
        for (BeerBatch item : tickets.values()) {
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
        for (BeerBatch item : tickets.values()) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void printQueue() {
        for (BeerBatch item : tickets.values()) {
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

    public BeerBatch find(String name) {
        return tickets.get(name);
    }

    public void closeDay(String message) {
        for (BeerBatch item : tickets.values()) {
            ServiceLocator.audit().write("close;" + item.getName());
        }
        for (Actor actor : actors) {
            ServiceLocator.email().send(actor.name(), message);
        }
    }
}
