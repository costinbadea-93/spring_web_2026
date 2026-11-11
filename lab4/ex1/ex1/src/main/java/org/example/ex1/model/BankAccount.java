package org.example.ex1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {

    private String accountNumber;
    private String accountOwnerName;
    private double accountBalance;
}
