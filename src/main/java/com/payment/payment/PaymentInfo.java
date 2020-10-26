package com.payment.payment;

import com.payment.common.Currency;
import com.payment.server.Database;
import com.payment.user.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentInfo {
    private User user;
    private PhoneAndAmountToPay phoneAndAmountToPay;
    private Currency currency;
    private String phoneNumber;
    private String amountToPay;
    private Database database;

    public PaymentInfo(User user, PhoneAndAmountToPay phoneAndAmountToPay, Currency currency) {
        this.user = user;
        this.phoneAndAmountToPay = phoneAndAmountToPay;
        this.currency = currency;
    }
}
