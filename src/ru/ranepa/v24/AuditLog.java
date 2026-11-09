package ru.ranepa.v24;

public class AuditLog {

    public void write(String line) {
        System.out.println("AUDIT: " + line);
    }
}
