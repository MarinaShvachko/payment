package com.payment;

import com.payment.app.MobileApp;
import com.payment.server.Server;
import com.payment.user.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //создала отправителя
        User vasia = new User("89124445566", "Вася", "Пупкин", 64, 1, 654345);

        //создала приложение
        MobileApp app = new MobileApp();

        //получила с консоли номер телефона, по которому отправлю деньги и сумму
        ArrayList<String> pnoneAndAmount = app.ReceivePhoneNumberAndMoneyFromConsole();

        //отправляю информацию для оплаты на сервер
        app.payUsingPnonenumber(vasia, pnoneAndAmount);

        Server server = new Server("199.188.89.89", 8800, "TCP");
        //сохраняю на сервере номер телефона и сумму для перевода
        server.listOfPhonesAndAmountsToPAy(pnoneAndAmount);

    }
}
