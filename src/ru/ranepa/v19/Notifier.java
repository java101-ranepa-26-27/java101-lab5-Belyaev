package ru.ranepa.v19;

public class Notifier {

    public void send(String recipient, String message) {
        System.out.println("PUSH -> " + recipient + ": " + message);
    }
}
