package com.payment;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //создала отправителя
        User vasia = new User("89124445566", "Вася", "Пупкин", 645544, 1, 654345);

        //создала получателя
        User masha = new User("89125555111", "Маша", "Орехова", 200, 2, 644477);

        //создала приложение отправителя, как его привязать к отправителю?
        App app = new App();

        //получила номер телефона, по которому отправлю деньги и сумму
        ArrayList<Integer> c = app.ReceivePhoneNumber();
        System.out.println(c.get(0));
        System.out.println(c.get(1));
    }
}
