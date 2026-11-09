package ru.ranepa.v02;

public class Mechanic implements Staff {

    private final String name;

    public Mechanic(String name) {
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
        item.cancel();
        System.out.println(name + " отменяет " + item.name);
    }

    @Override
    public void clean() {
        System.out.println(name + " убирает рабочее место");
    }

    @Override
    public String report() {
        return "Сотрудник " + name + " (механик)";
    }
}
