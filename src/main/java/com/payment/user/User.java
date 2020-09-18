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
    //private Currency currency;

    public User(String phoneNumber, String name, String familyname, PersonBankAccount personBankAccount) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.familyname = familyname;
        this.personBankAccount = personBankAccount;
        this.accountBalance = personBankAccount.getAccountBalance();
        this.bankAccountNumber = personBankAccount.getBankAccountNumber();
        //this.currency = personBankAccount.getCurrency();
    }

//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }

//    public String getFamilyname() {
//        return familyname;
//    }
//    public void setFamilyname(String familyname) {
//        this.familyname = familyname;
//    }

//    public PersonBankAccount getPersonBankAccount() {
//        return personBankAccount;
//    }
//    public void setPersonBankAccount(PersonBankAccount personBankAccount) {
//        this.personBankAccount = personBankAccount;
//    }

//    public void setAccountBalance(BigDecimal accountBalance) {
//        this.accountBalance = accountBalance;
//    }

//    public void setBankAccountNumber(int bankAccountNumber) {
//        this.bankAccountNumber = bankAccountNumber;
//    }
}
