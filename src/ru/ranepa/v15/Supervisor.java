package ru.ranepa.v15;

public class Supervisor extends Employee implements Actor {

    public Supervisor(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " проверяет работу");
    }

    @Override
    public void serve(Show item) {
        throw new UnsupportedOperationException("супервайзер не обслуживает");
    }

    @Override
    public void audit(Show item) {
        System.out.println(getName() + " проводит аудит " + item.name);
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException("супервайзер не убирает");
    }

    @Override
    public void bill(Show item) {
        System.out.println(getName() + " выставляет счёт " + item.name);
    }
}
