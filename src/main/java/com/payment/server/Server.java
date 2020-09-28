package com.payment.server;

import com.payment.payment.Payment;
import com.payment.validation.AmountValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Server {
    private String hostAddress;
    private int port;
    private String protocol;

    public boolean listOfPhonesAndAmountsToPay (Payment paymentDetails) {
        //проверка хватит ли денег, если нет - вернет ошибку - ее ловит приложение и отвечает
        BigDecimal currentAmountOfMoney = paymentDetails.getUser().getAccountBalance();
        BigDecimal amountOfMoneyToPay = new BigDecimal(paymentDetails.getAmountToPay() );
        AmountValidation amountValidation = new AmountValidation();

        //домашнее задание хранение деталей пользователя \ платежа
        Database<Integer, String> database = new Database<>();
        //database.putInDatabase(1, "89123334455"); //Только для теста на дублирующие значения

        //домашнее задание - проверка на дублирующий запрос
        database.checkOnDatabase(database, paymentDetails);

        //если все проверки прошли:
        if (amountValidation.isPaymentPossible(currentAmountOfMoney, amountOfMoneyToPay)) {
            //уменьшить сумму на счете
            paymentDetails.getUser().setAccountBalance(currentAmountOfMoney.subtract(amountOfMoneyToPay));
            //установить статус платежа
            paymentDetails.setStatus("Платеж прошел");
            //записать в базу данных
            database.putInDatabase(paymentDetails.hashCode(), paymentDetails.getPhoneNumber());
            //только для теста
            //database.showInDatabase();
            //System.out.println(" пользователь " + paymentDetails.getUser().getName() + " заплатил на номер телефона " + paymentDetails.getPhoneNumber() + " сумму " + paymentDetails.getAmountToPay() + " валюта = " + paymentDetails.getCurrency());
             return true;
        } else {
            return false;
        }
    }
}
