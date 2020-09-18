package com.payment.app;

import com.payment.common.Currency;
import com.payment.common.Pay;
import com.payment.common.ReceiveDataForPayment;
import com.payment.exception.PaymentValidationExeption;
import com.payment.user.User;
import com.payment.validation.AmountValidation;

import java.math.BigDecimal;
import java.util.ArrayList;

//более гибко делать интерфейс, а для каждого типа приложения создавать класс, пример - телефонное приложение, десктопное приложение и т.п.

public class MobileApp implements Pay, ReceiveDataForPayment {

        //оплатить: с какого счета, кому(на какой номер), сколько
        @Override
        public ArrayList<String> payUsingPnonenumber(User user, ArrayList<String> pnoneAndAmount, Currency currency) {
                //имеющиеся деньги на счете
                BigDecimal currentAmountOfMoney = user.getAccountBalance();
                //сумма для списания со счета
                BigDecimal amountOfManeyToPay = new BigDecimal(pnoneAndAmount.get(1));
                //проверка хватит ли денег для оплаты
                AmountValidation amountValidation = new AmountValidation();
                if (amountValidation.isPaymantPossible(currentAmountOfMoney, amountOfManeyToPay)) {
                        //уменьшила сумму на счете
                        user.setAccountBalance(currentAmountOfMoney.subtract(amountOfManeyToPay));
                        pnoneAndAmount.add(currency.getCurrency());
                        System.out.println("Баланс обновлен и =  " + user.getAccountBalance());/////////////////////////////////////////////
                } else {
                        throw new PaymentValidationExeption("Недостаточно денег на счете");
                }
                return pnoneAndAmount;
        }
}
