package com.payment;

import com.payment.user.User;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface Pay {
    public ArrayList<String> payUsingPnonenumber(User user, ArrayList<String> s);

     // передает данные на сервер, если сервер получил, считаем платеж отправлен успешно
    //могут быть добавлены другие споcобы оплаты, по номеру каhты, по паспорту и т.п.


}
