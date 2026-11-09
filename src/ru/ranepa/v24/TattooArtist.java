package ru.ranepa.v24;

public class TattooArtist implements Actor {

    private final String name;

    public TattooArtist(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void process(Tattoo item) {
        item.process();
        System.out.println(name + " ведёт " + item.getName());
    }

    @Override
    public void escalate(Tattoo item) {
        throw new UnsupportedOperationException("сотрудник не эскалирует заявки");
    }

    @Override
    public void comment(Tattoo item) {
        System.out.println(name + " комментирует " + item.getName());
    }

    @Override
    public void notify(Tattoo item) {
        System.out.println(name + " уведомляет по " + item.getName());
    }

    @Override
    public void close(Tattoo item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
