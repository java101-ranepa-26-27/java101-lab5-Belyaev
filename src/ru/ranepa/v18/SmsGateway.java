package ru.ranepa.v18;

public class SmsGateway {

    public void send(String recipient, String message) {
        System.out.println("SMS -> " + recipient + ": " + message);
    }
}
