package ru.ranepa.v08;

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
    public void process(Exhibit item) {
        item.process();
        System.out.println(name + " автоматически обработал " + item.getName());
    }

    @Override
    public void escalate(Exhibit item) {
        throw new UnsupportedOperationException("бот не эскалирует заявки");
    }

    @Override
    public void comment(Exhibit item) {
        throw new UnsupportedOperationException("бот не комментирует заявки");
    }

    @Override
    public void notify(Exhibit item) {
        System.out.println(name + " отправляет уведомление по " + item.getName());
    }

    @Override
    public void close(Exhibit item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
