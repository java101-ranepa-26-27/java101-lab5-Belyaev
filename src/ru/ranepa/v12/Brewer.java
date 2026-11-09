package ru.ranepa.v12;

public class Brewer implements Actor {

    private final String name;

    public Brewer(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void process(BeerBatch item) {
        item.process();
        System.out.println(name + " ведёт " + item.getName());
    }

    @Override
    public void escalate(BeerBatch item) {
        throw new UnsupportedOperationException("сотрудник не эскалирует заявки");
    }

    @Override
    public void comment(BeerBatch item) {
        System.out.println(name + " комментирует " + item.getName());
    }

    @Override
    public void notify(BeerBatch item) {
        System.out.println(name + " уведомляет по " + item.getName());
    }

    @Override
    public void close(BeerBatch item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
