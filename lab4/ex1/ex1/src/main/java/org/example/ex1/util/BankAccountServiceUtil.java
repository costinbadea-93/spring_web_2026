package org.example.ex1.util;

import org.example.ex1.model.BankAccount;

public class BankAccountServiceUtil {

    public static String computeETag(BankAccount bankAccount) {
        // Compute ETag based on the account's balance
        return bankAccount.getAccountNumber() + bankAccount.getAccountOwnerName();
    }
}
