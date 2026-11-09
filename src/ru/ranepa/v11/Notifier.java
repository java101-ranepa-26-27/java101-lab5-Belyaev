package ru.ranepa.v11;

public class Notifier {

    public void send(String recipient, String message) {
        System.out.println("PUSH -> " + recipient + ": " + message);
    }
}
