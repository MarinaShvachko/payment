package com.payment;

import com.payment.app.MobileApp;
import com.payment.user.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //создала отправителя
        User vasia = new User("89124445566", "Вася", "Пупкин", 645544, 1, 654345);

        //создала получателя, а зачем если я номер тела ввожу с консоли
        //User masha = new User("89125555111", "Маша", "Орехова", 200, 2, 644477);

        //создала приложение отправителя, как его привязать к отправителю?
        MobileApp app = new MobileApp();

        //получила номер телефона, по которому отправлю деньги и сумму
        ArrayList<String> c = app.ReceivePhoneNumberAndMoneyFromConsole();
//        System.out.println(c.get(0));
//        System.out.println(c.get(1));
        app.payUsingPnonenumber(vasia, c);
    }
}
