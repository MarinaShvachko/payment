package com.payment.server;

import com.payment.payment.Payment;
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
    public void listOfPhonesAndAmountsToPAy (Payment pnoneAndAmount) {
                    //проверка хватит ли денег если нет - ошибку - ее ловит приложение и отвечает
                    //если денег хватит то успех, использовать статус платежа




        ArrayList<Payment> x = new ArrayList<>();
        x.add(pnoneAndAmount);

        for (Payment s : x) {
            System.out.println("Деньги отправляет = " + s.getUser().getName() + " телефон зачисления = " + s.getPhoneNumber() + " сумма зачисления = " + s.getAmountToPay() + " валюта = " + s.getCurrency());
        }
    }
}
