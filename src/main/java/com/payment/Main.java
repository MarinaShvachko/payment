package com.payment;

import com.payment.app.MobileApp;
import com.payment.bankAccount.PersonBankAccount;
import com.payment.common.Currency;
import com.payment.common.ReceiveDataForPayment;
import com.payment.payment.Payment;
import com.payment.server.Database;
import com.payment.server.Server;
import com.payment.user.User;
import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {

        PersonBankAccount personBankAccount = new PersonBankAccount(123456789, new BigDecimal(87L), Currency.RUB);

        User vasia = new User("89124445566", "Вася", "Пупкин", personBankAccount);

        MobileApp app = new MobileApp();

        Server server = new Server("199.188.89.89", 8800, "TCP");

        //получить с консоли номер телефона, на который отправить деньги,  сумму для перевода, сохранить в объект
        Payment pnoneAndAmount = ReceiveDataForPayment.ReceivePhoneNumberAndMoneyFromConsole();

        //домашнее задание - проверка на дублирующий запрос
        Database<Integer, String> database = new Database<>();
        database.putInDatabase(1, "89123334455");
        database.checkOnDatabase(database, pnoneAndAmount); //есть ли в дб такой уже обьект, сейчас проверяю по телефону для наглядности

        //отправить обьект с информацией для оплаты на сервер
        app.payUsingPhoneNumber(vasia, pnoneAndAmount, personBankAccount.getCurrency(), database);

        //сервер обрабатывает платеж и возвращает статус,
        //в зависимости от статуса приложение выводит сообщение для пользователя
        app.renewStatusOfPayment(server.listOfPhonesAndAmountsToPay(pnoneAndAmount));
    }
}