package ru.ranepa.v06;

public class SmsGateway {

    public void send(String recipient, String message) {
        System.out.println("SMS -> " + recipient + ": " + message);
    }
}
