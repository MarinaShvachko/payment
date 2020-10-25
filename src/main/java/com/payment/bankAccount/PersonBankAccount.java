package com.payment.bankAccount;

import com.payment.common.Currency;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Getter
@Configuration
public class PersonBankAccount {
    private int bankAccountNumber;
    private BigDecimal accountBalance;
    private Currency currency;

    public void initializePersonBankAccount(int bankAccountNumber, BigDecimal accountBalance, Currency currency) {
        this.bankAccountNumber = bankAccountNumber;
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}
