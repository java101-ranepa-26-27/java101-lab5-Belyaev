package ru.ranepa.v23;

public class Notifier {

    public void send(String recipient, String message) {
        System.out.println("PUSH -> " + recipient + ": " + message);
    }
}
