package ru.ranepa.v03;

public class Clerk extends Employee implements Actor {

    public Clerk(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " обслуживает");
    }

    @Override
    public void serve(Bouquet item) {
        System.out.println(getName() + " обслуживает " + item.name);
    }

    @Override
    public void audit(Bouquet item) {
        throw new UnsupportedOperationException("клерк не проводит аудит");
    }

    @Override
    public void clean() {
        System.out.println(getName() + " убирает");
    }

    @Override
    public void bill(Bouquet item) {
        System.out.println(getName() + " выставляет счёт " + item.name);
    }
}
