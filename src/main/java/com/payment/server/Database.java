package com.payment.server;

import com.payment.payment.Payment;
import java.util.*;

public class Database {

    Map<Integer, String> database = new TreeMap<>();

    public Map<Integer, String> getDatabase() {
        return database;
    }

    //для удобства тестирования складываю телефон, вообще будет складываться обьект
    public void putInDatabase(Payment p) {
        database.put (p.hashCode(), p.getPhoneNumber());
    }

    //для теста на повторяющиеся значения
//    public void putInDatabaseTest(Integer i, String s) {
//        database.put(i, s);
//    }

    //только для теста
    public void showInDatabase() {
        for (Map.Entry entry : database.entrySet()) {
            System.out.println(entry.getKey() + " " +  entry.getValue() + " Это содержимое базы");
        }
     }
}
