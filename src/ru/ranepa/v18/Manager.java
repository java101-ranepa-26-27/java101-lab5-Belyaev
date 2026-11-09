package ru.ranepa.v18;

public class Manager implements Staff {

    private final String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void confirm(DanceClass item) {
        item.confirm();
        System.out.println(name + " подтверждает " + item.name);
    }

    @Override
    public void cancel(DanceClass item) {
        throw new UnsupportedOperationException("менеджер не отменяет записи");
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException("менеджер не убирает рабочее место");
    }

    @Override
    public String report() {
        return "Менеджер " + name;
    }
}
