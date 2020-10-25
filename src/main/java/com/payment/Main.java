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

        ApplicationContext context = new AnnotationConfigApplicationContext("com.payment");

        PersonBankAccount personBankAccount = context.getBean(PersonBankAccount.class);
        personBankAccount.initializePersonBankAccount(123456789, new BigDecimal(87L), Currency.RUB);

        User vasia = new User("89124445566", "Вася", "Пупкин", personBankAccount);

        MobileApp app = context.getBean(MobileApp.class);

        Server server = new Server("199.188.89.89", 8800, "TCP");

        //получить с консоли номер телефона, на который отправить деньги,  сумму для перевода, сохранить в объект
        PhoneAndAmountToPay pnoneAndAmount = ReceiveDataForPayment.ReceivePhoneNumberAndMoneyFromConsole();

        //домашнее задание - проверка на дублирующий запрос
        Database<Integer, String> database = new Database<>();
        app.checkOnDatabase(database, pnoneAndAmount);

        //обогатить объект phoneAndAmount доп. данными для платежа и вернуть новый обьект
        PaymentInfo paymentInfo = app.putTogetherPaymentInfoToSendToServer(vasia, pnoneAndAmount, Currency.RUB, database);

        //сервер обрабатывает платеж и возвращает статус
         server.listOfPhonesAndAmountsToPay(paymentInfo);
    }
}