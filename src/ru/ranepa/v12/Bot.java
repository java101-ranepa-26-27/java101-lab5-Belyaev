package ru.ranepa.v12;

public class Bot implements Actor {

    private final String name;

    public Bot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void process(BeerBatch item) {
        item.process();
        System.out.println(name + " автоматически обработал " + item.getName());
    }

    @Override
    public void escalate(BeerBatch item) {
        throw new UnsupportedOperationException("бот не эскалирует заявки");
    }

    @Override
    public void comment(BeerBatch item) {
        throw new UnsupportedOperationException("бот не комментирует заявки");
    }

    @Override
    public void notify(BeerBatch item) {
        System.out.println(name + " отправляет уведомление по " + item.getName());
    }

    @Override
    public void close(BeerBatch item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
