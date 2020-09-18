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

        //оплатить: с какого счета, кому(на какой номер), сколько
        @Override
        public Payment payUsingPnonenumber(User user, Payment pnoneAndAmount, Currency currency) {
                this.currency = currency.getCurrency();
                this.user = user;
                //имеющиеся деньги на счете
                BigDecimal currentAmountOfMoney = user.getAccountBalance();
                //сумма для списания со счета
                BigDecimal amountOfManeyToPay = new BigDecimal(pnoneAndAmount.getAmountToPay() );
                //проверка хватит ли денег для оплаты
                AmountValidation amountValidation = new AmountValidation();
                if (amountValidation.isPaymantPossible(currentAmountOfMoney, amountOfManeyToPay)) {
                        //уменьшила сумму на счете
                        user.setAccountBalance(currentAmountOfMoney.subtract(amountOfManeyToPay));
                        //pnoneAndAmount.setBankAccountNumber(user.getBankAccountNumber());
                        pnoneAndAmount.setUser(user);
                        pnoneAndAmount.setCurrency(currency);
                        System.out.println("Баланс обновлен и =  " + user.getAccountBalance());/////////////////////////////////////////////
                } else {
                        throw new PaymentValidationExeption("Недостаточно денег на счете");
                }
                return pnoneAndAmount;
        }
}
