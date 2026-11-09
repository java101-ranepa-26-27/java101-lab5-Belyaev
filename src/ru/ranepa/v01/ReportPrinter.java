package ru.ranepa.v01;

public class ReportPrinter {

    public void print(Drink item) {
        if (item instanceof Coffee) {
            Coffee first = (Coffee) item;
            System.out.println("Кофе: " + first.name + ", цена " + first.price);
        } else if (item instanceof Tea) {
            Tea second = (Tea) item;
            System.out.println("Чай: " + second.name + ", цена " + second.price);
        } else {
            System.out.println("Неизвестный напиток: " + item.name);
        }
    }
}
