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
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        PersonBankAccount personBankAccount = new PersonBankAccount(123456789, new BigDecimal(87L), Currency.RUB);

        User vasia = new User("89124445566", "Вася", "Пупкин", personBankAccount);

        MobileApp app = new MobileApp();

        Server server = new Server("199.188.89.89", 8800, "TCP");

        //получить с консоли номер телефона, по которому отправить деньги и сумму, сохранить в объект
        Payment pnoneAndAmount = ReceiveDataForPayment.ReceivePhoneNumberAndMoneyFromConsole();

        //реализация домашнего задания Добавить на стороне приложения проверку на дублирующий запрос, урок 12
        Database database = new Database();
        //только для теста на дублирующий запрос
        //database.putInDatabase ( 918, "89126555555");
        app.checkOnDatabase(database, pnoneAndAmount);

        //отправляю обьект с информацией для оплаты на сервер
        app.payUsingPhoneNumber(vasia, pnoneAndAmount, personBankAccount.getCurrency());

        //На сервере платеж обрабатывается и возвращает статус,
        //в зависимости от статуса выводится сообщение для пользователя
        app.renewStatusOfPayment(server.listOfPhonesAndAmountsToPay(pnoneAndAmount));
        //database.showInDatabase();
    }
}
