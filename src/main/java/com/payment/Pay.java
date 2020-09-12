package com.payment;

import com.payment.user.User;

import java.util.ArrayList;

public interface Pay {
    public void payUsingPnonenumber(User user, ArrayList<String> s);

     // передает данные на сервер, если сервер получил, считаем платеж отправлен успешно
    //могут быть добавлены другие спообы оплаты, по номеру каты, по паспорту и т.п.

    //public void payUsingPnonenumber2(User user, String phone, String summa);
}
