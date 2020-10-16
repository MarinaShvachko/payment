package com.payment.payment;

import com.payment.common.Currency;
import com.payment.server.Database;
import com.payment.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhoneAndAmountToPay {

    private User user;
    private String phoneNumber;
    private String amountToPay;
    private Currency currency;

}
