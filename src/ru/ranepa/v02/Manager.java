package ru.ranepa.v02;

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
    public void confirm(Bike item) {
        item.confirm();
        System.out.println(name + " подтверждает " + item.name);
    }

    @Override
    public void cancel(Bike item) {
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
