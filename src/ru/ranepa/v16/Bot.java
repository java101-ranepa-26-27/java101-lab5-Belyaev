package ru.ranepa.v16;

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
    public void process(TrainingCar item) {
        item.process();
        System.out.println(name + " автоматически обработал " + item.getName());
    }

    @Override
    public void escalate(TrainingCar item) {
        throw new UnsupportedOperationException("бот не эскалирует заявки");
    }

    @Override
    public void comment(TrainingCar item) {
        throw new UnsupportedOperationException("бот не комментирует заявки");
    }

    @Override
    public void notify(TrainingCar item) {
        System.out.println(name + " отправляет уведомление по " + item.getName());
    }

    @Override
    public void close(TrainingCar item) {
        System.out.println(name + " закрывает " + item.getName());
    }
}
