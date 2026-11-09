package ru.ranepa.v08;

public class AuditLog {

    public void write(String line) {
        System.out.println("AUDIT: " + line);
    }
}
