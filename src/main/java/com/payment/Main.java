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

        //создала отправителя и передала счет
        User vasia = new User("89124445566", "Вася", "Пупкин", personBankAccount);

        //создала приложение
        MobileApp app = new MobileApp();

        //создала сервер
        Server server = new Server("199.188.89.89", 8800, "TCP");

        //получила с консоли номер телефона, по которому отправлю деньги и сумму, сохранила в объект
        Payment pnoneAndAmount = app.ReceivePhoneNumberAndMoneyFromConsole();

        //отправляю обьект с информацией для оплаты на сервер
        app.payUsingPnonenumber(vasia, pnoneAndAmount, personBankAccount.getCurrency());

        //передаю данные платежа на сервер, там платеж обрабатывается и возвращается статус,
        //в зависимости от статуса выводится сообщение для пользователя
        app.renewStatusOfPayment(server.listOfPhonesAndAmountsToPAy(pnoneAndAmount));
    }
}
