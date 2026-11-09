package ru.ranepa.v20;

public class ArchivedDevice extends BasicDevice {

    public ArchivedDevice(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException("устройство не подлежит ремонту");
    }
}
