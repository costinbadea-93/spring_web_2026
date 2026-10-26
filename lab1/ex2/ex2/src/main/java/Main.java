import config.ContextConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BankAccountService;

public class Main {
    public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        var bankAccountService = context.getBean(BankAccountService.class);
        bankAccountService.connectAndAudit();
    }
}
