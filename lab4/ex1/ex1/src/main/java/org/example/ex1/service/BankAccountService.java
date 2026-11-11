package org.example.ex1.service;

import org.example.ex1.model.BankAccount;

import java.util.List;

public interface BankAccountService {
     BankAccount addNewBankAccount(BankAccount bankAccount);
     List<BankAccount> retrieveAllAccounts();
     BankAccount findByAccountNumber(String accountNumber);
}
