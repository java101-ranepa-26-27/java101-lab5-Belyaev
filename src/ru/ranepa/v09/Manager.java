package ru.ranepa.v09;

public class Manager implements ShiftWorker {

    private final String name;
    private double salaryAmount;

    public Manager(String name, double salaryAmount) {
        this.name = name;
        this.salaryAmount = salaryAmount;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void handle(Lane item) {
        throw new UnsupportedOperationException("менеджер не обрабатывает объект: " + item.name);
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException("менеджер не убирает рабочее место");
    }

    @Override
    public void openShift() {
        System.out.println(name + " открывает смену");
    }

    @Override
    public double salary() {
        return salaryAmount;
    }

    @Override
    public String report() {
        return "Менеджер " + name + ", зарплата " + salaryAmount;
    }
}
