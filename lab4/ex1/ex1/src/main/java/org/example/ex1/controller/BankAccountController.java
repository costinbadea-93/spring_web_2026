package org.example.ex1.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ex1.model.BankAccount;
import org.example.ex1.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.example.ex1.util.BankAccountServiceUtil.computeETag;

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
    public ResponseEntity<?> addNewBankAccount(@RequestBody @Valid BankAccount bankAccount, HttpServletRequest request) {
        URI uri =  ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/api/v1/bankAccount/find/{accountNumber}")
                .buildAndExpand(bankAccount.getAccountNumber())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(bankAccountService.addNewBankAccount(bankAccount));
    }

    @GetMapping("/find/{accountNumber}")
    public ResponseEntity<?> findBankAccountByNumber(@PathVariable String accountNumber) {

        BankAccount bankAccount = bankAccountService.findByAccountNumber(accountNumber);
        String eTag = computeETag(bankAccount);

        return ResponseEntity
                .ok()
                .eTag(eTag)
                .body(bankAccount);

    }

    @PutMapping("/update/{accountNumber}")
    public ResponseEntity<?> findBankAccountByNumber(@PathVariable String accountNumber,
                                                     @RequestParam double balance,
                                                     HttpServletRequest request) {

        String ifMatch = request.getHeader("If-Match");

        return ResponseEntity
                .ok(bankAccountService.updateBalance(accountNumber, balance, ifMatch));
    }



}