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
        public ArrayList<Payment> payUsingPnonenumber (User user, ArrayList<Payment> paymentDetailes, Currency currency) {
                ArrayList<Payment> p = paymentDetailes;
                for (int x = 0; x < paymentDetailes.size(); x++) {
                        this.currency = currency.getCurrency();
                        this.user = user;
                        paymentDetailes.get(x).setUser(user);
                        paymentDetailes.get(x).setCurrency(currency);
                }
                return p; //обьект точно передается.
        }

        //если ответ от сервера положительный - выводим на ui оповещение
        public void renewStatusOfPayment(ArrayList<Payment> p) {
//                ArrayList<Payment> status = p;
                for (int x = 0; x < p.size(); x ++) {
                        System.out.println(p.get(x).getStatus().equals("Успех") ? "Платеж на сумму " +  p.get(x).getAmountToPay() + " " + p.get(x).getStatus() :"Платеж на сумму " +  p.get(x).getAmountToPay() + " " + p.get(x).getStatus());
                }
        }
}
