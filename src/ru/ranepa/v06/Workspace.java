package ru.ranepa.v06;

public class Workspace {

    public String id;
    public String name;
    public WorkspaceKind kind;
    public double price;
    public boolean confirmed;

    public Workspace(String id, String name, WorkspaceKind kind, double price) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.confirmed = false;
    }

    public void confirm() {
        confirmed = true;
        System.out.println(name + " подтверждён");
    }

    public void cancel() {
        confirmed = false;
        System.out.println(name + " отменён");
    }
}
