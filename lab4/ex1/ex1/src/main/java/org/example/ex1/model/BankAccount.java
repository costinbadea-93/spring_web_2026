package org.example.ex1.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {

    private Integer id;

    @NotNull(message = "Account number cannot be null")
    @NotEmpty(message = "Account number cannot be empty")
    private String accountNumber;
    private String accountOwnerName;
    private double accountBalance;
}
