package ru.ranepa.v16;

public class Instructor implements Actor {

    private final String name;

    public Instructor(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void process(TrainingCar item) {
        item.process();
        System.out.println(name + " ведёт " + item.getName());
    }

    @Override
    public void escalate(TrainingCar item) {
        throw new UnsupportedOperationException("сотрудник не эскалирует заявки");
    }

    @Override
    public void comment(TrainingCar item) {
        System.out.println(name + " комментирует " + item.getName());
    }

    @Override
    public void notify(TrainingCar item) {
        System.out.println(name + " уведомляет по " + item.getName());
    }

    @Override
    public void close(TrainingCar item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
