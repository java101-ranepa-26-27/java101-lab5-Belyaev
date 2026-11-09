package ru.ranepa.v10;

public class Ranger implements Staff {

    private final String name;

    public Ranger(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void confirm(CampingSpot item) {
        item.confirm();
        System.out.println(name + " подтверждает " + item.name);
    }

    @Override
    public void cancel(CampingSpot item) {
        item.cancel();
        System.out.println(name + " отменяет " + item.name);
    }

    @Override
    public void clean() {
        System.out.println(name + " убирает рабочее место");
    }

    @Override
    public String report() {
        return "Сотрудник " + name + " (рейнджер)";
    }
}
