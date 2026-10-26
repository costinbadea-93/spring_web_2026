package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import utils.AuditLogger;

@Component
public class BankAccountService {

//    @Autowired
//    @Qualifier("oracle")
    private final DbConnection dbConnection;
//    @Autowired
    private final AuditLogger auditLogger;

    public BankAccountService(@Qualifier("oracle") DbConnection dbConnection, AuditLogger auditLogger) {
        this.dbConnection = dbConnection;
        this.auditLogger = auditLogger;
    }


    public void connectAndAudit() {
        dbConnection.connectToDb();
        auditLogger.logMessage("Connected to database successfully.");

    }
}
