package ru.ranepa.v20;

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
    public void process(Device item) {
        item.process();
        System.out.println(name + " автоматически обработал " + item.getName());
    }

    @Override
    public void escalate(Device item) {
        throw new UnsupportedOperationException("бот не эскалирует заявки");
    }

    @Override
    public void comment(Device item) {
        throw new UnsupportedOperationException("бот не комментирует заявки");
    }

    @Override
    public void notify(Device item) {
        System.out.println(name + " отправляет уведомление по " + item.getName());
    }

    @Override
    public void close(Device item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
