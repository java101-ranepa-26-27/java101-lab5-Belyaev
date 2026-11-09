package ru.ranepa.v11;

public class Trainee extends Clerk {

    public Trainee(String name) {
        super(name);
    }

    @Override
    public void work() {
        throw new UnsupportedOperationException("стажёр не работает самостоятельно");
    }
}
