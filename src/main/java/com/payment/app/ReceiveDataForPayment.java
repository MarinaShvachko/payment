package com.payment.app;

import com.payment.validation.PhoneValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public interface ReceiveDataForPayment {
    //получить с консоли номер телефона на который деньги переводить
    //public ArrayList<String> ReceivePhoneNumberAndMoneyFromConsole();

    //далее могут быть методы получить из файла, из базы данных и т.п.


    public default ArrayList<String> ReceivePhoneNumberAndMoneyFromConsole() {
        Scanner scaner = new Scanner(System.in);
        String phoneNumber = "";
        String amountToPay = "";
        ArrayList<String> phoneAndAmount = new ArrayList<String>();
        System.out.println("Введите номер телефона в формате 89121115533");

        try {
            phoneNumber = scaner.nextLine();
            PhoneValidation validate = new PhoneValidation();
            while (!validate.validatePhoneLengthAndSimbols(phoneNumber)) {
                System.out.println("Введенный номер не соответствует шаблону 89121115533");
                phoneNumber = scaner.nextLine();
            }
            System.out.println("Введите сумму для перевода");
            //TODO: 12.09.2020 добавить валидацию для введенной суммы
            amountToPay = scaner.nextLine();
        } catch (
                IOException e) {
            System.out.println(e);
        }
        phoneAndAmount.add(phoneNumber);
        phoneAndAmount.add(amountToPay);
        return phoneAndAmount;
    }
}

