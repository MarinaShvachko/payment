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
    //принимает оплату от приложения
    // TODO: 12.09.2020   добавить проверку на получаемые данные
    private String hostAddress;
    private int port;
    private String protocol;

    //Добавить на стороне сервера коллекцию для хранения деталей пользователя
    public boolean listOfPhonesAndAmountsToPAy (Payment paymentDetails) {
        //проверка хватит ли денег если нет - ошибку - ее ловит приложение и отвечает
        //если денег хватит то успех, использовать статус платежа
        BigDecimal currentAmountOfMoney = paymentDetails.getUser().getAccountBalance();
        //сумма для списания со счета
        BigDecimal amountOfManeyToPay = new BigDecimal(paymentDetails.getAmountToPay() );
        AmountValidation amountValidation = new AmountValidation();

        if (amountValidation.isPaymantPossible(currentAmountOfMoney, amountOfManeyToPay)) {
            //уменьшила сумму на счете
            paymentDetails.getUser().setAccountBalance(currentAmountOfMoney.subtract(amountOfManeyToPay));
            System.out.println("Баланс обновлен и =  " + paymentDetails.getUser().getAccountBalance());/////////////////////////////////////////////
            paymentDetails.setStatus("Платеж прошел"); /////////////////
            //если все прошло успешно сохраняю на сервер
            ArrayList<Payment> x = new ArrayList<>();
            x.add(paymentDetails);

            for (Payment s : x) {
                System.out.println("Деньги отправляет = " + s.getUser().getName() + " телефон зачисления = " + s.getPhoneNumber() + " сумма зачисления = " + s.getAmountToPay() + " валюта = " + s.getCurrency() + " статус платежа = " + paymentDetails.getStatus());
            }


            return true;
        } else {
            return false;
            //throw new PaymentValidationExeption("Недостаточно денег на счете");

        }
    }
}
