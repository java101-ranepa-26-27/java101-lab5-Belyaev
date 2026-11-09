package ru.ranepa.v11;

public class Supervisor extends Employee implements Actor {

    public Supervisor(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " проверяет работу");
    }

    @Override
    public void serve(Publication item) {
        throw new UnsupportedOperationException("супервайзер не обслуживает");
    }

    @Override
    public void audit(Publication item) {
        System.out.println(getName() + " проводит аудит " + item.name);
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException("супервайзер не убирает");
    }

    @Override
    public void bill(Publication item) {
        System.out.println(getName() + " выставляет счёт " + item.name);
    }
}
