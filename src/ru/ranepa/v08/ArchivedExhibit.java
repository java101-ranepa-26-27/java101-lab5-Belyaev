package ru.ranepa.v08;

public class ArchivedExhibit extends BasicExhibit {

    public ArchivedExhibit(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException("экспонат на реставрации");
    }
}
