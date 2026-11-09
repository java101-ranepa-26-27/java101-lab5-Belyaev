package ru.ranepa.v03;

public class Supervisor extends Employee implements Actor {

    public Supervisor(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " проверяет работу");
    }

    @Override
    public void serve(Bouquet item) {
        throw new UnsupportedOperationException("супервайзер не обслуживает");
    }

    @Override
    public void audit(Bouquet item) {
        System.out.println(getName() + " проводит аудит " + item.name);
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException("супервайзер не убирает");
    }

    @Override
    public void bill(Bouquet item) {
        System.out.println(getName() + " выставляет счёт " + item.name);
    }
}
