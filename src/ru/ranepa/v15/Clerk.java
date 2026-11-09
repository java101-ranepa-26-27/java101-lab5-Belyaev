package ru.ranepa.v15;

public class Clerk extends Employee implements Actor {

    public Clerk(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " обслуживает");
    }

    @Override
    public void serve(Show item) {
        System.out.println(getName() + " обслуживает " + item.name);
    }

    @Override
    public void audit(Show item) {
        throw new UnsupportedOperationException("клерк не проводит аудит");
    }

    @Override
    public void clean() {
        System.out.println(getName() + " убирает");
    }

    @Override
    public void bill(Show item) {
        System.out.println(getName() + " выставляет счёт " + item.name);
    }
}
