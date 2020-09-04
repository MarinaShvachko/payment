package com.payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public interface ReceiveDataForPayment {
    //получить с консоли номер телефона на который деньги переводить
    public ArrayList<Integer> ReceivePhoneNumber();


}

