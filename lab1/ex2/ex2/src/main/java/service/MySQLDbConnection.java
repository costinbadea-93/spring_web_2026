package service;

import org.springframework.stereotype.Component;

@Component("mysql")
public class MySQLDbConnection implements DbConnection {
    @Override
    public void connectToDb() {
        System.out.println("Connecting to MySQL database...");
    }
}
