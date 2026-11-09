package ru.ranepa.v22;

public class Consultant implements Staff {

    private final String name;

    public Consultant(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void confirm(BoardGame item) {
        item.confirm();
        System.out.println(name + " подтверждает " + item.name);
    }

    @Override
    public void cancel(BoardGame item) {
        item.cancel();
        System.out.println(name + " отменяет " + item.name);
    }

    @Override
    public void clean() {
        System.out.println(name + " убирает рабочее место");
    }

    @Override
    public String report() {
        return "Сотрудник " + name + " (консультант)";
    }
}
