package com.payment.common;

import com.payment.payment.Payment;
import com.payment.validation.PhoneValidation;

import java.io.IOException;
import java.util.Scanner;

public interface ReceiveDataForPayment {
    //получить с консоли номер телефона на который деньги переводить
    //далее могут быть методы получить данные из файла, из базы данных и т.п.

    static Payment ReceivePhoneNumberAndMoneyFromConsole() {
        Scanner scaner = new Scanner(System.in);
        String phoneNumber = "";
        String amountToPay="";
        Payment payment = new Payment();
        System.out.println("Введите номер телефона в формате 89121115533");

             try {
                phoneNumber = scaner.nextLine();
                PhoneValidation validate = new PhoneValidation(); //сюда передать параметр
                while (!validate.validatePhoneLengthAndSimbols(phoneNumber)) {
                    System.out.println("Введенный номер не соответствует шаблону 89121115533");
                    phoneNumber = scaner.nextLine();
                }
                System.out.println("Введите сумму для перевода");
                //TODO: 12.09.2020 добавить валидацию для введенной суммы
                amountToPay = scaner.nextLine();
                //TODO: подумать как прекратить исполнение программы вместо system.exit - может return
            } catch (IOException e) {
                 System.exit(1);
            }

            payment.setPhoneNumber(phoneNumber);
            payment.setAmountToPay(amountToPay);

            return payment;
        }
}

