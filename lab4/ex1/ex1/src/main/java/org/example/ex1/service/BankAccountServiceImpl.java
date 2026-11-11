package org.example.ex1.service;

import lombok.extern.slf4j.Slf4j;
import org.example.ex1.model.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BankAccountServiceImpl implements BankAccountService{

    private final List<BankAccount> bankAccounts;

    public BankAccountServiceImpl() {
        this.bankAccounts =  new ArrayList<>();
        bankAccounts.add(BankAccount.builder()
                .accountNumber("1234567890")
                .accountOwnerName("John Doe0")
                .accountBalance(1000.0)
                .build());
        bankAccounts.add(BankAccount.builder()
                .accountNumber("1234567891")
                .accountOwnerName("John Doe1")
                .accountBalance(2000.0)
                .build());
        bankAccounts.add(BankAccount.builder()
                .accountNumber("1234567892")
                .accountOwnerName("John Doe2")
                .accountBalance(3000.0)
                .build());
    }

    @Override
    public BankAccount addNewBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
        log.info("Added new bank account, {}", bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> retrieveAllAccounts() {
        log.info("Retrieving all bank accounts, {}", bankAccounts);
        return bankAccounts;
    }

    @Override
    public BankAccount findByAccountNumber(String accountNumber) {
        return bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Bank account not found for account number: " + accountNumber));
    }
}
