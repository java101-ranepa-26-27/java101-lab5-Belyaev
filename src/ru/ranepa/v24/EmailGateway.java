package ru.ranepa.v24;

public class EmailGateway {

    public void send(String recipient, String message) {
        System.out.println("EMAIL -> " + recipient + ": " + message);
    }
}
