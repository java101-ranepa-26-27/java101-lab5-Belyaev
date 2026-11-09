package ru.ranepa.v22;

public class CancelledBoardGame extends BoardGame {

    public CancelledBoardGame(String id, String name, BoardGameKind kind, double price) {
        super(id, name, kind, price);
    }

    @Override
    public void confirm() {
        throw new UnsupportedOperationException("в игре не хватает компонентов");
    }
}
