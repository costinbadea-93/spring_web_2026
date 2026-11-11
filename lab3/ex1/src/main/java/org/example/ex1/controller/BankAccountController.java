package org.example.ex1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ex1.model.BankAccount;
import org.example.ex1.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("api/v1/bank-account")
@RequiredArgsConstructor
@Validated
public class BankAccountController {

//    @GetMapping("/details")
//    //http://localhost:9095/api/v1/bank-account/details
//    public String getBankAccountDetails() {
//        return "Bank account details";
//    }

    private final BankAccountService bankAccountService;

//    @GetMapping("/details")
//    //REST -> REpresentational State Transfer
//    //http://localhost:9095/api/v1/bank-account/details?accountNumber=1234567890 -> request param
//    //http://localhost:9095/api/v1/bank-account/details/{accountNumber} -> path variable
//    public BankAccount getBankAccountDetails(@RequestParam String accountNumber) {
//        return bankAccountService.getAllBankAccounts(accountNumber);
//    }


    @GetMapping("/details/{accountNumber}")
    //REST -> REpresentational State Transfer
    //http://localhost:9095/api/v1/bank-account/details?accountNumber=1234567890 -> request param
    //http://localhost:9095/api/v1/bank-account/details/{accountNumber} -> path variable
    public ResponseEntity<?> getBankAccountDetails(@PathVariable String accountNumber) {
//        try {
//            return bankAccountService.getAllBankAccounts(accountNumber);
            return ResponseEntity
                    .ok(bankAccountService.getAllBankAccounts(accountNumber));
//        }catch (RuntimeException e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(e.getMessage());
//        }
    }

    @PostMapping("/new")
    public ResponseEntity<?> createBankAccount(@RequestBody @Valid BankAccount bankAccount, WebRequest request) {
       return ResponseEntity.ok(bankAccountService.createBankAccount(bankAccount));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBankAccounts() {
        return ResponseEntity.ok(bankAccountService.retrieveBankAccounts());
    }
}
