package org.example.ex1.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ex1.model.BankAccount;
import org.example.ex1.repository.BankAccountRepository;
import org.example.ex1.repository.BankAccountRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.example.ex1.util.BankAccountServiceUtil.computeETag;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService{

    private final List<BankAccount> bankAccounts;
    private final BankAccountRepository bankAccountRepository;

//    public BankAccountServiceImpl() {
//        this.bankAccounts =  new ArrayList<>();
//        bankAccounts.add(BankAccount.builder()
//                .accountNumber("1234567890")
//                .accountOwnerName("John Doe0")
//                .accountBalance(1000.0)
//                .build());
//        bankAccounts.add(BankAccount.builder()
//                .accountNumber("1234567891")
//                .accountOwnerName("John Doe1")
//                .accountBalance(2000.0)
//                .build());
//        bankAccounts.add(BankAccount.builder()
//                .accountNumber("1234567892")
//                .accountOwnerName("John Doe2")
//                .accountBalance(3000.0)
//                .build());
//    }

    @Override
    public BankAccount addNewBankAccount(BankAccount bankAccount) {

//        Validator validator = Validation
//                .buildDefaultValidatorFactory()
//                .getValidator();
//
//        var violations = validator.validate(bankAccount);

//        bankAccounts.add(bankAccount);
       BankAccount result = bankAccountRepository.addNewBankAccount(bankAccount);

        log.info("Added new bank account, {}", bankAccount);
        return result;
    }

    @Override
    public List<BankAccount> retrieveAllAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.retrieveAllAccounts();
        log.info("Retrieving all bank accounts, {}", bankAccounts);
        return bankAccounts;
    }

    @Override
    public BankAccount findByAccountNumber(String accountNumber) {
        return bankAccountRepository.findByAccountNumber(accountNumber);
//        return bankAccounts.stream()
//                .filter(bankAccount -> bankAccount.getAccountNumber().equals(accountNumber))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Bank account not found for account number: " + accountNumber));
    }


    @Override
    public int updateBalance(String accountNumber, double newBalance, String ifMatch) {
        BankAccount exiting =  bankAccountRepository.findByAccountNumber(accountNumber);

        String exitingIfMatch = computeETag(exiting);

        if(exitingIfMatch.equals(ifMatch)){
            return bankAccountRepository.updateBalance(accountNumber, newBalance);
        }
        else {
            throw new RuntimeException("ETag mismatch. The resource has been modified by another process.");
        }
//        return bankAccounts.stream()
//                .filter(bankAccount -> bankAccount.getAccountNumber().equals(accountNumber))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Bank account not found for account number: " + accountNumber));
    }



}
