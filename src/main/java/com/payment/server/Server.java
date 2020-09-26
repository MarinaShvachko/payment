package com.payment.server;

import com.payment.exception.PaymentValidationExeption;
import com.payment.payment.Payment;
import com.payment.validation.AmountValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class Server {
    private String hostAddress;
    private int port;
    private String protocol;
    private Database database;

    public boolean listOfPhonesAndAmountsToPay (Payment paymentDetails) {
        //проверка хватит ли денег, если нет - вернет ошибку - ее ловит приложение и отвечает
        BigDecimal currentAmountOfMoney = paymentDetails.getUser().getAccountBalance();
        BigDecimal amountOfMoneyToPay = new BigDecimal(paymentDetails.getAmountToPay() );
        AmountValidation amountValidation = new AmountValidation();

        if (amountValidation.isPaymentPossible(currentAmountOfMoney, amountOfMoneyToPay)) {
            //уменьшить сумму на счете
            paymentDetails.getUser().setAccountBalance(currentAmountOfMoney.subtract(amountOfMoneyToPay));
            //установить статус
            paymentDetails.setStatus("Платеж прошел");

            //Данные с успешными платежами будут храниться в базе данных
            Database<Integer, String> d = new Database();
            d.putInDatabase(paymentDetails.hashCode(), paymentDetails.getPhoneNumber());
            //d.showInDatabase(); //только для теста
             return true;
        } else {
            return false;
        }
    }
}
