package com.payment.server;

import com.payment.exception.PaymentValidationExeption;
import com.payment.exception.ServerValidationExeption;
import com.payment.payment.Payment;
import java.util.*;

public class Database<T1, T2> {
    T1 object1;
    T2 object2;

    Map<T1, T2> database = new TreeMap<>();

    public Map<T1, T2> getDatabase() {
        return database;
    }

    public void putInDatabase(T1 object1, T2 object2 ) {
        database.put (object1, object2);
    }

    //только для теста, проверить что в БД сохранилось
    public void showInDatabase() {
        for (Map.Entry entry : database.entrySet()) {
            System.out.println(entry.getKey() + " " +  entry.getValue() + " Это содержимое базы");
        }
     }

     //проверяю дубли по номеру телефона а не по хэшкоду только для теста
    public void checkOnDatabase(Database d, Payment p) {
        for (Object x : d.getDatabase().entrySet()) {
            if (d.getDatabase().containsValue(p.getPhoneNumber())) {
                throw new ServerValidationExeption("Дублирующий запрос!");
            }
        }
    }
}
