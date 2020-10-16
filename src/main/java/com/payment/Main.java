package com.payment;

import com.payment.app.MobileApp;
import com.payment.bankAccount.PersonBankAccount;
import com.payment.common.Currency;
import com.payment.common.ReceiveDataForPayment;
import com.payment.payment.PaymentInfo;
import com.payment.payment.PhoneAndAmountToPay;
import com.payment.server.Database;
import com.payment.server.Server;
import com.payment.user.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        PersonBankAccount personBankAccount = new PersonBankAccount(123456789, new BigDecimal(87L), Currency.RUB);

        User vasia = new User("89124445566", "Вася", "Пупкин", personBankAccount);

        ApplicationContext ctxApp = new AnnotationConfigApplicationContext(MobileApp.class);
        MobileApp app = ctxApp.getBean(MobileApp.class);

        Server server = new Server("199.188.89.89", 8800, "TCP");

        //получить с консоли номер телефона, на который отправить деньги,  сумму для перевода, сохранить в объект
        PhoneAndAmountToPay pnoneAndAmount = ReceiveDataForPayment.ReceivePhoneNumberAndMoneyFromConsole();

        //домашнее задание - проверка на дублирующий запрос
        Database<Integer, String> database = new Database<>();
        app.checkOnDatabase(database, pnoneAndAmount);

        //обьект со всеми данными для платежа
        PaymentInfo paymentInfo = app.putTogetherPaymentInfoToSendToServer(vasia, pnoneAndAmount, Currency.RUB, database);

        //сервер обрабатывает платеж и возвращает статус,
        //в зависимости от статуса приложение выводит сообщение для пользователя
         server.listOfPhonesAndAmountsToPay(paymentInfo);
    }
}