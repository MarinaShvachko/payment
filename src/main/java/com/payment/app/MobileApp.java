package com.payment.app;

import com.payment.common.Currency;
import com.payment.common.Pay;
import com.payment.common.ReceiveDataForPayment;
import com.payment.exception.PaymentValidationExeption;
import com.payment.exception.ServerValidationExeption;
import com.payment.payment.Payment;
import com.payment.server.Database;
import com.payment.user.User;
import java.util.Map;

public class MobileApp implements Pay {
        String currency="";
        User user;

        //оплатить: кто платит, кому(на какой номер), сколько, валюта
        @Override
        public Payment payUsingPhoneNumber(User user, Payment paymentDetailes, Currency currency) {
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

        //сделала проверку на дублирующие значения на стороне приложения только для реализации домашнего задания урок 12
        //добавить на стороне приложения проверку на дублирующий запрос
        public void checkOnDatabase(Database d, Payment p) {
               for (Object x : d.getDatabase().entrySet()) {
                       if (d.getDatabase().containsValue(p.getPhoneNumber())) {
                               throw new PaymentValidationExeption("Дублирующий запрос!");
                       }
               }
        }
}
