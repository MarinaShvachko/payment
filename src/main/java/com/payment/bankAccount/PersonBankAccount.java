package com.payment.bankAccount;

import com.payment.common.Currency;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
public class PersonBankAccount {
    private int bankAccountNumber;
    private BigDecimal accountBalance;
    private Currency currency;

    public PersonBankAccount(int bankAccountNumber, BigDecimal accountBalance, Currency currency) {
        this.bankAccountNumber = bankAccountNumber;
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}
