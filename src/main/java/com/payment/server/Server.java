package com.payment.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    public void listOfPhonesAndAmountsToPAy (ArrayList<String> pnoneAndAmount) {
        HashMap<String, String> phoneAndHowMuch = new HashMap<>();
        phoneAndHowMuch.put(pnoneAndAmount.get(0), pnoneAndAmount.get(1));

        for (HashMap.Entry x : phoneAndHowMuch.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }

        //return phonesAndAmountToPayNow;
    }
}
