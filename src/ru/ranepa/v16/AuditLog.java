package ru.ranepa.v16;

public class AuditLog {

    public void write(String line) {
        System.out.println("AUDIT: " + line);
    }
}
