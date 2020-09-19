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
        //создает счет
        PersonBankAccount personBankAccount = new PersonBankAccount(123456789, new BigDecimal(87L), Currency.RUB);

        //создает пользователя
        User vasia = new User("89124445566", "Вася", "Пупкин", personBankAccount);

        //создает приложение
        MobileApp app = new MobileApp();

        //создает сервер
        Server server = new Server("199.188.89.89", 8800, "TCP");


        //работа приложения:
        //получает с консоли номер телефона и сумму
        ArrayList<Payment> pnoneAndAmount = app.ReceivePhoneNumberAndMoneyFromConsole(); // получаем аррей лист с обьектами платежей

        //отправляет обьект \ ArrayList обьектов с информацией для оплаты на сервер
        ArrayList<Payment> x = app.payUsingPnonenumber(vasia, pnoneAndAmount, personBankAccount.getCurrency());
        //server.listOfPhonesAndAmountsToPAy(x);

        //app.showp(x);

        //сервер обрабатывает платеж и возвращается статус,
        //в зависимости от статуса выводится сообщение для пользователя
        app.renewStatusOfPayment(server.listOfPhonesAndAmountsToPAy(x));

    }
}