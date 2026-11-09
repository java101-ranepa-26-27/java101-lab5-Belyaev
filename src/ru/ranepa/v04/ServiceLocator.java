package ru.ranepa.v04;

public class ServiceLocator {

    private static final EmailGateway EMAIL = new EmailGateway();
    private static final AuditLog AUDIT = new AuditLog();

    public static EmailGateway email() {
        return EMAIL;
    }

    public static AuditLog audit() {
        return AUDIT;
    }
}
