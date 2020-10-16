package com.payment.server;

import com.payment.payment.PaymentInfo;
import com.payment.validation.AmountValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Server {
    private String hostAddress;
    private int port;
    private String protocol;

    //проверка хватит ли денег, возвращается boolean, приложение обрабатывает и выводит на UI пользователю
    public boolean listOfPhonesAndAmountsToPay (PaymentInfo paymentDetails) {
        BigDecimal currentAmountOfMoney = paymentDetails.getUser().getAccountBalance();

        BigDecimal amountOfMoneyToPay = new BigDecimal(paymentDetails.getAmountToPay());
        AmountValidation amountValidation = new AmountValidation();

        if (amountValidation.isPaymentPossible(currentAmountOfMoney, amountOfMoneyToPay)) {
            //уменьшить сумму на счете
            paymentDetails.getUser().setAccountBalance(currentAmountOfMoney.subtract(amountOfMoneyToPay));
            //записать в базу данных
            paymentDetails.getDatabase().putInDatabase(paymentDetails.hashCode(), paymentDetails.getPhoneNumber());
            //System.out.println(" пользователь " + paymentDetails.getUser().getName() + " заплатил на номер телефона " + paymentDetails.getPhoneNumber() + " сумму " + paymentDetails.getAmountToPay() + " валюта = " + paymentDetails.getCurrency());
             return true;
        } else {
            //System.out.println("не прошел");
            return false;
        }
    }
}
