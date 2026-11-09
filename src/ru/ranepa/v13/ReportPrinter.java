package ru.ranepa.v13;

public class ReportPrinter {

    public void print(Animal item) {
        if (item instanceof Cow) {
            Cow first = (Cow) item;
            System.out.println("Корова: " + first.name + ", цена " + first.price);
        } else if (item instanceof Chicken) {
            Chicken second = (Chicken) item;
            System.out.println("Курица: " + second.name + ", цена " + second.price);
        } else {
            System.out.println("Неизвестное животное: " + item.name);
        }
    }
}
