package ru.ranepa.v23;

public class Clerk extends Employee implements Actor {

    public Clerk(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " обслуживает");
    }

    @Override
    public void serve(BakeryItem item) {
        System.out.println(getName() + " обслуживает " + item.name);
    }

    @Override
    public void audit(BakeryItem item) {
        throw new UnsupportedOperationException("клерк не проводит аудит");
    }

    @Override
    public void clean() {
        System.out.println(getName() + " убирает");
    }

    @Override
    public void bill(BakeryItem item) {
        System.out.println(getName() + " выставляет счёт " + item.name);
    }
}
