package ru.ranepa.v21;

public class ReportPrinter {

    public void print(Bottle item) {
        if (item instanceof StillBottle) {
            StillBottle first = (StillBottle) item;
            System.out.println("Без газа: " + first.name + ", цена " + first.price);
        } else if (item instanceof SparklingBottle) {
            SparklingBottle second = (SparklingBottle) item;
            System.out.println("С газом: " + second.name + ", цена " + second.price);
        } else {
            System.out.println("Неизвестная бутыль: " + item.name);
        }
    }
}
