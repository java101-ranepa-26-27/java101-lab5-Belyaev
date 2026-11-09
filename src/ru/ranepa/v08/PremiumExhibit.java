package ru.ranepa.v08;

public class PremiumExhibit extends AbstractExhibit {

    public PremiumExhibit(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println(getName() + " выставлен (приоритет)");
    }

    @Override
    public void cancel() {
        System.out.println(getName() + " отменён с возвратом");
    }
}
