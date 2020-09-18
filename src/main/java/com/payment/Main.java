package com.payment;

import com.payment.app.MobileApp;
import com.payment.bankAccount.PersonBankAccount;
import com.payment.common.Currency;
import com.payment.payment.Payment;
import com.payment.server.Server;
import com.payment.user.User;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //создала счет
        PersonBankAccount personBankAccount = new PersonBankAccount(123456789, new BigDecimal(87L), Currency.RUB);
        //System.out.println(personBankAccount.getCurrency());

        //создала отправителя и передала счет
        User vasia = new User("89124445566", "Вася", "Пупкин", personBankAccount);

        //создала приложение
        MobileApp app = new MobileApp();

        //получила с консоли номер телефона, по которому отправлю деньги и сумму
        Payment pnoneAndAmount = app.ReceivePhoneNumberAndMoneyFromConsole();

        //отправляю информацию для оплаты на сервер
        app.payUsingPnonenumber(vasia, pnoneAndAmount, personBankAccount.getCurrency());

        Server server = new Server("199.188.89.89", 8800, "TCP");
        //сохраняю на сервере номер телефона и сумму для перевода
        server.listOfPhonesAndAmountsToPAy(pnoneAndAmount);

    }
}
