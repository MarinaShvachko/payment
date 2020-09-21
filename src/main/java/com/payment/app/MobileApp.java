package com.payment.app;

import com.payment.common.Currency;
import com.payment.common.Pay;
import com.payment.common.ReceiveDataForPayment;
import com.payment.exception.PaymentValidationExeption;
import com.payment.payment.Payment;
import com.payment.user.User;
import com.payment.validation.AmountValidation;

import java.math.BigDecimal;
import java.util.ArrayList;

//более гибко делать интерфейс, а для каждого типа приложения создавать класс, пример - телефонное приложение, десктопное приложение и т.п.

public class MobileApp implements Pay, ReceiveDataForPayment {
        String currency="";
        User user;

        //оплатить: кто платит, кому(на какой номер), сколько, валюта
        @Override
        public Payment payUsingPnonenumber(User user, Payment paymentDetailes, Currency currency) {
                this.currency = currency.getCurrency();
                this.user = user;
                paymentDetailes.setUser(user);
                paymentDetailes.setCurrency(currency);
                return paymentDetailes;
        }

        //если ответ от сервера положительный - выводим на ui оповещение
        public void renewStatusOfPayment(Boolean b) {
                System.out.println(b? "Платеж успешный" : "Платеж не прошел, на счете недостаточно средств");
        }
}
