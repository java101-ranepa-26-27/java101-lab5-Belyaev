package ru.ranepa.v05;

public class ReportPrinter {

    public void print(LaundryItem item) {
        if (item instanceof Shirt) {
            Shirt first = (Shirt) item;
            System.out.println("Рубашка: " + first.name + ", цена " + first.price);
        } else if (item instanceof Coat) {
            Coat second = (Coat) item;
            System.out.println("Пальто: " + second.name + ", цена " + second.price);
        } else {
            System.out.println("Неизвестное изделие: " + item.name);
        }
    }
}
