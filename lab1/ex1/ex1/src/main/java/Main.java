import contextconfig.ContextConfiguration;
import model.BankAccount;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Salut la laboratorul de tehnici web!!!");

        /**
         * IOC -> INVERSION OF CONTROL
         *      DI -> DEPENDENCY INJECTION
         *
         * AOP -> ASPECT ORIENTED PROGRAMING
         */

//        var context =
//                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /**
         * adaugare de beans in context:
         *  1)@Bean -> nativa
         *  2)Adnotari stereotype(@Service, @Component, @Reposytory, @Controller, @RestController etc...
         */

//        BankAccount bankAccount = context.getBean(BankAccount.class);
//        BankAccount bankAccount1 = (BankAccount) context.getBean("bankAccount1");
//        BankAccount bankAccount2 = (BankAccount) context.getBean("bankAccount2");

        BankAccount bankAccount1 = (BankAccount) context.getBean("bk1");
        BankAccount bankAccount2 = (BankAccount) context.getBean("bk1");


        System.out.println("Retrieving bank accounts from context:");
        System.out.println(bankAccount1);
        System.out.println(bankAccount2);


        /**
         * Bean scopes
         *  -scopul default al oricarui bean este SINGLETON
         *  -protorype scope
         *
         *  -request scope
         *  -session scope
         *  -application scope
         */

        System.out.println(bankAccount1.hashCode());
        System.out.println(bankAccount2.hashCode());

        /**
         * Bean Initialisation
         * -eager -> odata cu contextul de spring
         * -lazy -> beanul se creaza in momentul apelului primei actiuni pe care o pun e la dispozitie
         */


    }
}
