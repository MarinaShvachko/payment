package com.payment.server;

import com.payment.exception.PaymentValidationExeption;
import com.payment.payment.Payment;
import com.payment.validation.AmountValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class Server {
    private String hostAddress;
    private int port;
    private String protocol;

    //Добавить на стороне сервера коллекцию для хранения деталей пользователя
    public ArrayList<Payment> listOfPhonesAndAmountsToPAy (ArrayList<Payment> paymentDetails) {
        //проверка хватит ли денег, если нет - ошибку - ее ловит приложение и отвечает
        ArrayList<Payment> paymentDetailsOnServer = paymentDetails;
        //если денег хватит то успех, списываются деньги


        for (int x = 0; x < paymentDetailsOnServer.size(); x ++ ) {
            BigDecimal currentAmountOfMoney = paymentDetailsOnServer.get(x).getUser().getAccountBalance();
            //сумма для списания со счета
            BigDecimal amountOfManeyToPay = new BigDecimal(paymentDetails.get(x).getAmountToPay());
            AmountValidation amountValidation = new AmountValidation();

            if (amountValidation.isPaymantPossible(currentAmountOfMoney, amountOfManeyToPay)) {
                //если на счете денег достаточно - уменьшить сумму на счете
                paymentDetails.get(x).getUser().setAccountBalance(currentAmountOfMoney.subtract(amountOfManeyToPay));
                System.out.println("Баланс обновлен и =  " + paymentDetails.get(x).getUser().getAccountBalance());/////////////////////////////////////////////
                paymentDetails.get(x).setStatus("Исполнен"); /////////////////
                //сохранить на сервер детали платежа
                ArrayList<Payment> detailesOfSuccessPayments = new ArrayList<>();
                detailesOfSuccessPayments.add(paymentDetailsOnServer.get(x));

                for (Payment s : detailesOfSuccessPayments) {
                    //System.out.println("Деньги отправляет = " + s.getUser().getName() + " телефон зачисления = " + s.getPhoneNumber() + " сумма зачисления = " + s.getAmountToPay() + " валюта = " + s.getCurrency() + " статус платежа = " + paymentDetailsOnServer. get(x).getStatus());
                }


            } else {
                paymentDetails.get(x).setStatus("Не исполнен");
               // System.out.println(paymentDetails.get(x).getStatus());
            }

        }
        return paymentDetailsOnServer;

        }

}
