package ru.ranepa.v24;

public class ArchivedTattoo extends BasicTattoo {

    public ArchivedTattoo(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException("у клиента аллергия, нанесение невозможно");
    }
}
