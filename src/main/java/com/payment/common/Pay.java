package com.payment.common;

import com.payment.payment.Payment;
import com.payment.user.User;

import java.util.ArrayList;

public interface Pay {
    ArrayList<Payment> payUsingPnonenumber(User user, ArrayList<Payment> p, Currency currency);

     // передает данные на сервер, если сервер получил, считаем платеж отправлен успешно
    //могут быть добавлены другие споcобы оплаты, по номеру карты, по паспорту и т.п.


}
