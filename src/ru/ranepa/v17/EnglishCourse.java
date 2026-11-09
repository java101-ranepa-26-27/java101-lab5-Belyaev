package ru.ranepa.v17;

public class EnglishCourse extends Course {

    public EnglishCourse(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "английский";
    }
}
