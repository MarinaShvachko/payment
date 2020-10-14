package com.payment.app;

import com.payment.common.Currency;
import com.payment.common.Pay;
import com.payment.payment.Payment;
import com.payment.server.Database;
import com.payment.user.User;

public class MobileApp implements Pay {
        String currency="";
        User user;

        //оплатить: кто платит, кому(на какой номер), сколько, валюта
        @Override
        public Payment payUsingPhoneNumber(User user, Payment paymentDetailes, Currency currency, Database database) { //этот метод в класс в коммон
                this.currency = currency.getCurrency();
                this.user = user;
                paymentDetailes.setUser(user);
                paymentDetailes.setCurrency(currency);
                paymentDetailes.setDatabase(database);
                return paymentDetailes;
        }

        //если ответ от сервера положительный - выводим на ui оповещение
        public void renewStatusOfPayment(Boolean b) {
                System.out.println(b? "Платеж успешный" : "Платеж не прошел, на счете недостаточно средств");
        }
}

//собрать в методе все для формирования обьекта платежа