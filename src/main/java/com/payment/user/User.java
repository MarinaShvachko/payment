package com.payment.user;

import com.payment.bankAccount.PersonBankAccount;
import com.payment.common.Currency;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class User {
    private String phoneNumber;
    private String name;
    private String familyname;
    private PersonBankAccount personBankAccount;
    private BigDecimal accountBalance;
    private int bankAccountNumber;

    public User(String phoneNumber, String name, String familyname, PersonBankAccount personBankAccount) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.familyname = familyname;
        this.personBankAccount = personBankAccount;
        this.accountBalance = personBankAccount.getAccountBalance();
        this.bankAccountNumber = personBankAccount.getBankAccountNumber();
    }
}
