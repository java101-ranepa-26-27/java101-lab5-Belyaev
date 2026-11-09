package ru.ranepa.v16;

public class EmailGateway {

    public void send(String recipient, String message) {
        System.out.println("EMAIL -> " + recipient + ": " + message);
    }
}
