package ru.ranepa.v21;

public class Courier implements ShiftWorker {

    private final String name;
    private double salaryAmount;

    public Courier(String name, double salaryAmount) {
        this.name = name;
        this.salaryAmount = salaryAmount;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void handle(Bottle item) {
        System.out.println(name + " обрабатывает объект: " + item.name);
    }

    @Override
    public void clean() {
        System.out.println(name + " убирает рабочее место");
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
        return "Сотрудник " + name + " (курьер), зарплата " + salaryAmount;
    }
}
