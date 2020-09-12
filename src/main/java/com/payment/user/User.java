package com.payment.user;

import java.math.BigDecimal;

public class User {
    private String phoneNumber;
    private String name;
    private String familyname;
    private PersonBankAccount account;

    public User(String phoneNumber, String name, String familyname, int accountBalance, int clientNumber, int bankAccountNumber) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.familyname = familyname;
        this.account = new PersonBankAccount();
        account.setAccountBalance(BigDecimal.valueOf(accountBalance));
        account.setCurrency("Ru");
        account.setClientNumber(clientNumber);
        account.setBankAccountNumber(bankAccountNumber);
    }

    public BigDecimal getAccountBalance() {
        return account.getAccountBalance();
    }

    public String getCurrency() {
        return account.getCurrency();
    }

    public int getClientNumber() {
        return account.getClientNumber();
    }

    public int getBankAccountNumber() {
        return account.getBankAccountNumber();
    }
}
