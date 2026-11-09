package ru.ranepa.v09;

public class ReportPrinter {

    public void print(Lane item) {
        if (item instanceof StandardLane) {
            StandardLane first = (StandardLane) item;
            System.out.println("Стандартная: " + first.name + ", цена " + first.price);
        } else if (item instanceof VIPLane) {
            VIPLane second = (VIPLane) item;
            System.out.println("VIP: " + second.name + ", цена " + second.price);
        } else {
            System.out.println("Неизвестная дорожка: " + item.name);
        }
    }
}
