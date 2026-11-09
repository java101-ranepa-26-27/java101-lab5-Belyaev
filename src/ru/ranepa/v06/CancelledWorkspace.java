package ru.ranepa.v06;

public class CancelledWorkspace extends Workspace {

    public CancelledWorkspace(String id, String name, WorkspaceKind kind, double price) {
        super(id, name, kind, price);
    }

    @Override
    public void confirm() {
        throw new UnsupportedOperationException("стол неисправен и не бронируется");
    }
}
