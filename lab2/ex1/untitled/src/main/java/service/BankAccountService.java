package service;

import model.BankAccount;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    public boolean makeTransfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        if (fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            System.out.println("Transfer successful: " + amount +
                    " transferred from account " + fromAccount.getAccountNumber() +
                    " to account " + toAccount.getAccountNumber());
            return true;
        } else {
            throw new RuntimeException("Insufficient funds in the source account.");
        }
    }
}
