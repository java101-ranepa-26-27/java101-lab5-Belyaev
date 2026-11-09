package ru.ranepa.v14;

public class SmsGateway {

    public void send(String recipient, String message) {
        System.out.println("SMS -> " + recipient + ": " + message);
    }
}
