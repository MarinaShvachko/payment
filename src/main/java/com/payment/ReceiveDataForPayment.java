package com.payment;

import java.util.ArrayList;

public interface ReceiveDataForPayment {
    //получить с консоли номер телефона на который деньги переводить
    public ArrayList<String> ReceivePhoneNumberAndMoneyFromConsole();

    //далее могут быть методы получить из файла, из базы данных и т.п.


}

