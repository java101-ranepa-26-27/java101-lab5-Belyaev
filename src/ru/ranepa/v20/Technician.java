package ru.ranepa.v20;

public class Technician implements Actor {

    private final String name;

    public Technician(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void process(Device item) {
        item.process();
        System.out.println(name + " ведёт " + item.getName());
    }

    @Override
    public void escalate(Device item) {
        throw new UnsupportedOperationException("сотрудник не эскалирует заявки");
    }

    @Override
    public void comment(Device item) {
        System.out.println(name + " комментирует " + item.getName());
    }

    @Override
    public void notify(Device item) {
        System.out.println(name + " уведомляет по " + item.getName());
    }

    @Override
    public void close(Device item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
