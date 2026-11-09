package ru.ranepa.v08;

public class Curator implements Actor {

    private final String name;

    public Curator(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void process(Exhibit item) {
        item.process();
        System.out.println(name + " ведёт " + item.getName());
    }

    @Override
    public void escalate(Exhibit item) {
        throw new UnsupportedOperationException("сотрудник не эскалирует заявки");
    }

    @Override
    public void comment(Exhibit item) {
        System.out.println(name + " комментирует " + item.getName());
    }

    @Override
    public void notify(Exhibit item) {
        System.out.println(name + " уведомляет по " + item.getName());
    }

    @Override
    public void close(Exhibit item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
