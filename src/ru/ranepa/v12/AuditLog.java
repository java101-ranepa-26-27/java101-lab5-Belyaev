package ru.ranepa.v12;

public class AuditLog {

    public void write(String line) {
        System.out.println("AUDIT: " + line);
    }
}
