package com.payment.user;

//import com.sun.xml.internal.bind.v2.TODO;





import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PersonBankAccount {
    private int clientNumber;
    private int bankAccountNumber;
    private BigDecimal accountBalance;
    private String currency;

    // TODO: 31.08.2020 добавить автоматическую уникальную нумерацию при создании счета клиента 
//    public int getClientNumber() {
//        return clientNumber;
//    }
//
//    public void setClientNumber(int clientNumber) {
//        this.clientNumber = clientNumber;
//    }
//
//    public int getBankAccountNumber() {
//        return bankAccountNumber;
//    }
//
//    public void setBankAccountNumber(int bankAccountNumber) {
//        this.bankAccountNumber = bankAccountNumber;
//    }
//
//    public BigDecimal getAccountBalance() {
//        return accountBalance;
//    }
//
//    public void setAccountBalance(BigDecimal accountBalance) {
//        this.accountBalance = accountBalance;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
}
