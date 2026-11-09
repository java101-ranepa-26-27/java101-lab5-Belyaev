package ru.ranepa.v04;

public class Groomer implements Actor {

    private final String name;

    public Groomer(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void process(Pet item) {
        item.process();
        System.out.println(name + " ведёт " + item.getName());
    }

    @Override
    public void escalate(Pet item) {
        throw new UnsupportedOperationException("сотрудник не эскалирует заявки");
    }

    @Override
    public void comment(Pet item) {
        System.out.println(name + " комментирует " + item.getName());
    }

    @Override
    public void notify(Pet item) {
        System.out.println(name + " уведомляет по " + item.getName());
    }

    @Override
    public void close(Pet item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
