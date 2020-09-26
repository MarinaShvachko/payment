package com.payment.server;

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
