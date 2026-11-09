package ru.ranepa.v07;

public class Clerk extends Employee implements Actor {

    public Clerk(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " обслуживает");
    }

    @Override
    public void serve(Instrument item) {
        System.out.println(getName() + " обслуживает " + item.name);
    }

    @Override
    public void audit(Instrument item) {
        throw new UnsupportedOperationException("клерк не проводит аудит");
    }

    @Override
    public void clean() {
        System.out.println(getName() + " убирает");
    }

    @Override
    public void bill(Instrument item) {
        System.out.println(getName() + " выставляет счёт " + item.name);
    }
}
