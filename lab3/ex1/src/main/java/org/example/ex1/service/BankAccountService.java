package org.example.ex1.service;

import lombok.extern.slf4j.Slf4j;
import org.example.ex1.exceptions.ObjectNotFoundException;
import org.example.ex1.model.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BankAccountService {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccountService() {
        // Initialize with some dummy bank accounts
        bankAccounts.add(new BankAccount("00000501C5"));
        bankAccounts.add(new BankAccount("00000502C5"));
        bankAccounts.add(new BankAccount("00000503C5"));
    }

    public BankAccount getAllBankAccounts(String accountNumber) {
        log.info("Fetching all bank accounts: {}", bankAccounts);
        return bankAccounts
                .stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException("Bank account not found"));
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        log.info("Creating new bank account: {}", bankAccount);
        bankAccounts.add(bankAccount);
        return bankAccount;
    }

    public List<BankAccount> retrieveBankAccounts(){
        return bankAccounts;
    }
}
