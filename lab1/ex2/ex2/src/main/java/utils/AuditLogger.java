package utils;

import org.springframework.stereotype.Component;

@Component
public class AuditLogger {
    public void logMessage(String msg) {
        System.out.println("Audit Log: " + msg);
    }
}
