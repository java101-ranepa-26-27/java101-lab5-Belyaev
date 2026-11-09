package ru.ranepa.v19;

public class Clerk extends Employee implements Actor {

    public Clerk(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " обслуживает");
    }

    @Override
    public void serve(Shoot item) {
        System.out.println(getName() + " обслуживает " + item.name);
    }

    @Override
    public void audit(Shoot item) {
        throw new UnsupportedOperationException("клерк не проводит аудит");
    }

    @Override
    public void clean() {
        System.out.println(getName() + " убирает");
    }

    @Override
    public void bill(Shoot item) {
        System.out.println(getName() + " выставляет счёт " + item.name);
    }
}
