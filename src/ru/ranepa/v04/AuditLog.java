package ru.ranepa.v04;

public class AuditLog {

    public void write(String line) {
        System.out.println("AUDIT: " + line);
    }
}
