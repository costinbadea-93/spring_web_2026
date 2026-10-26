package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("oracle")
//@Qualifier("oracle")
public class OracleDbConnection implements DbConnection {
    @Override
    public void connectToDb() {
        System.out.println("Connecting to Oracle database...");
    }
}
