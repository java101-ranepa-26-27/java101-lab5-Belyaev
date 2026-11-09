package ru.ranepa.v13;

public class EmailService {

    public void send(String recipient, String message) {
        System.out.println("EMAIL -> " + recipient + ": " + message);
    }
}
