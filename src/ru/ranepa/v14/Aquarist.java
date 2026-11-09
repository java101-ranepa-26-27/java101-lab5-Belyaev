package ru.ranepa.v14;

public class Aquarist implements Staff {

    private final String name;

    public Aquarist(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void confirm(SeaCreature item) {
        item.confirm();
        System.out.println(name + " подтверждает " + item.name);
    }

    @Override
    public void cancel(SeaCreature item) {
        item.cancel();
        System.out.println(name + " отменяет " + item.name);
    }

    @Override
    public void clean() {
        System.out.println(name + " убирает рабочее место");
    }

    @Override
    public String report() {
        return "Сотрудник " + name + " (аквариумист)";
    }
}
