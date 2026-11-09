package ru.ranepa.v12;

public class EmailGateway {

    public void send(String recipient, String message) {
        System.out.println("EMAIL -> " + recipient + ": " + message);
    }
}
