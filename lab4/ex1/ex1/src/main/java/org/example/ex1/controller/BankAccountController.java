package org.example.ex1.controller;

import lombok.RequiredArgsConstructor;
import org.example.ex1.model.BankAccount;
import org.example.ex1.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bankAccount")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    /**
     * BankAccount
     * -addBankAccount
     * -findByBankAccountNumber
     * -retriveAllAccounts
     *
     * @return
     */


    @GetMapping("/list")
    public ResponseEntity<?> retrieveAllBankAccounts() {
        return ResponseEntity
                .ok(bankAccountService.retrieveAllAccounts());
    }


    @PostMapping("/new")
    public ResponseEntity<?> addNewBankAccount(@RequestBody BankAccount bankAccount) {
        return ResponseEntity
                .ok(bankAccountService.addNewBankAccount(bankAccount));
    }

    @GetMapping("/find/{accountNumber}")
    public ResponseEntity<?> findBankAccountByNumber(@PathVariable String accountNumber) {
        return ResponseEntity
                .ok(bankAccountService.findByAccountNumber(accountNumber));
    }
}