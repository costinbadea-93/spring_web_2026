package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankAccount {
    private String accountNumber;
    private double balance;

//    public BankAccount(String accountNumber, double balance) {
//        this.accountNumber = accountNumber;
//        this.balance = balance;
//    }

//    public String getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }

//    @Override
//    public String toString() {
//        return "BankAccount{" +
//                "accountNumber='" + accountNumber + '\'' +
//                ", balance=" + balance +
//                '}';
//    }
}
