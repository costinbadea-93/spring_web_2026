package contextconfig;

import model.BankAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {

    @Bean("bk1")
    @Scope("prototype")
    @Primary
    public BankAccount bankAccount1(){
        return new BankAccount("1234567890");
    }

    @Bean("bk2")
    public BankAccount bankAccount2(){
        return new BankAccount("0987654321");
    }
}
