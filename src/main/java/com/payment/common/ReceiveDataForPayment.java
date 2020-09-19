package com.payment.common;

import com.payment.payment.Payment;
import com.payment.validation.PhoneValidation;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public interface ReceiveDataForPayment {
    //получить с консоли номер телефона и сумму для оплаты, сохранить в обьект, обьекты сохраняются в лист обьектов
    default ArrayList<Payment> ReceivePhoneNumberAndMoneyFromConsole() {
        Scanner scaner = new Scanner(System.in);
        String phoneNumber = "";
        String amountToPay = "";
        ArrayList<Payment> phoneAndAmount = new ArrayList<>();

        System.out.println("Введите номер телефона в формате 89121115533");

        int x = 2;
        Payment payment;
        //while сделан для реализации домашней работы проверка на введенные значения на стороне приложения
        while (x > 0) {
            try {
            payment = new Payment();
            phoneNumber = scaner.nextLine();
            PhoneValidation validate = new PhoneValidation();
            while (!validate.validatePhoneLengthAndSimbols(phoneNumber)) {
            System.out.println("Введенный номер не соответствует шаблону 89121115533");
            phoneNumber = scaner.nextLine();
//            payment.setPhoneNumber(phoneNumber);
            }
            System.out.println("Введите сумму для перевода");
            //TODO: 12.09.2020 добавить валидацию для введенной суммы
            amountToPay = scaner.nextLine();

            payment.setPhoneNumber(phoneNumber);
            payment.setAmountToPay(amountToPay);
            phoneAndAmount.add(payment);
           // System.out.println(payment.getPhoneNumber() + " fhfhfh " + payment.getAmountToPay());

            } catch (IOException e) {
                System.out.println(e);
            }
            x--;
        }
        return phoneAndAmount;
    }
}

