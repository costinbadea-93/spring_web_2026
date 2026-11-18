package org.example.ex1.repository;

import org.example.ex1.model.BankAccount;

import java.util.List;

public interface BankAccountRepository {
    BankAccount addNewBankAccount(BankAccount bankAccount);
    List<BankAccount> retrieveAllAccounts();
    BankAccount findByAccountNumber(String accountNumber);
    int updateBalance(String accountNumber, double newBalance);
}
