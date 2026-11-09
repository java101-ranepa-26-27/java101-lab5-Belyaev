package ru.ranepa.v20;

public class AuditLog {

    public void write(String line) {
        System.out.println("AUDIT: " + line);
    }
}
