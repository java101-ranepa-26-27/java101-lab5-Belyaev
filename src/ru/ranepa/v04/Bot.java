package ru.ranepa.v04;

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
    public void process(Pet item) {
        item.process();
        System.out.println(name + " автоматически обработал " + item.getName());
    }

    @Override
    public void escalate(Pet item) {
        throw new UnsupportedOperationException("бот не эскалирует заявки");
    }

    @Override
    public void comment(Pet item) {
        throw new UnsupportedOperationException("бот не комментирует заявки");
    }

    @Override
    public void notify(Pet item) {
        System.out.println(name + " отправляет уведомление по " + item.getName());
    }

    @Override
    public void close(Pet item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
