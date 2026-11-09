package ru.ranepa.v06;

public class Administrator implements Staff {

    private final String name;

    public Administrator(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void confirm(Workspace item) {
        item.confirm();
        System.out.println(name + " подтверждает " + item.name);
    }

    @Override
    public void cancel(Workspace item) {
        item.cancel();
        System.out.println(name + " отменяет " + item.name);
    }

    @Override
    public void clean() {
        System.out.println(name + " убирает рабочее место");
    }

    @Override
    public String report() {
        return "Сотрудник " + name + " (администратор)";
    }
}
