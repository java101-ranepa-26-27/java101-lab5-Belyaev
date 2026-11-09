package ru.ranepa.v24;

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
    public void process(Tattoo item) {
        item.process();
        System.out.println(name + " автоматически обработал " + item.getName());
    }

    @Override
    public void escalate(Tattoo item) {
        throw new UnsupportedOperationException("бот не эскалирует заявки");
    }

    @Override
    public void comment(Tattoo item) {
        throw new UnsupportedOperationException("бот не комментирует заявки");
    }

    @Override
    public void notify(Tattoo item) {
        System.out.println(name + " отправляет уведомление по " + item.getName());
    }

    @Override
    public void close(Tattoo item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
