package com.payment.app;

import com.payment.common.Currency;
import com.payment.common.Pay;
import com.payment.payment.Payment;
import com.payment.server.Database;
import com.payment.user.User;

public class MobileApp implements Pay {
        private int currency;
        private User user;

        //оплатить: кто платит, кому(на какой номер), сколько, валюта
        @Override
        public Payment payUsingPhoneNumber(User user, Payment paymentDetailes, Currency currency, Database database) {
                this.currency = currency.getCurrency();
                this.user = user;
                paymentDetailes.setUser(user);
                paymentDetailes.setCurrency(currency);
                paymentDetailes.setDatabase(database);
                return paymentDetailes;
        }
}
