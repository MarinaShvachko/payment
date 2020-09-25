package com.payment.payment;

import com.payment.common.Currency;
import com.payment.user.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Payment {
    //от кого
    private User user;
    //кому
    private String phoneNumber;
    //сколько
    private String amountToPay;
    //валюта
    private Currency currency;
    //успешная оплата или ошибка
    private String status;
}
