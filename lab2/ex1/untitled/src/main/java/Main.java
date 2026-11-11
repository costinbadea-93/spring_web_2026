import context.ContextConfiguration;
import model.BankAccount;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BankAccountService;

public class Main {
    public static void main(String[] args) {
        var bankAccount1 =
                new BankAccount("123456789", 1000.0);
        var bankAccount2 =
                new BankAccount("987654321", 500.0);

        var context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        var bankAccountService = context.getBean(BankAccountService.class);

//        System.out.println("Before transfer:");
//        System.out.println(bankAccount1);
//        System.out.println(bankAccount2);

        bankAccountService.makeTransfer(bankAccount1, bankAccount2, 200.0);

//        System.out.println("After transfer:");
//        System.out.println(bankAccount1);
//        System.out.println(bankAccount2);
    }
}
