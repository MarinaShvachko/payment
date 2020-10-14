package com.payment.common;

import com.payment.exception.ServerValidationExeption;
import com.payment.payment.Payment;
import com.payment.phones.HomePhone;
//import com.payment.phones.MobilePhone;
import com.payment.phones.Phone;
//import com.payment.validation.PhoneValidation;
import com.payment.validation.PhoneValidation;
import com.payment.validation.UserPhoneValidation;

//import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public interface ReceiveDataForPayment {
    //получить с консоли номер телефона на который деньги переводить
    //далее могут быть методы получить данные из файла, из базы данных и т.п.

    static Payment ReceivePhoneNumberAndMoneyFromConsole() {
        Scanner scaner = new Scanner(System.in);
        String phoneNumber = "";
        String amountToPay="";
        Payment payment = new Payment();
        System.out.println("Введите номер телефона в формате 89121115533");

                phoneNumber = scaner.nextLine();
                Phone homePhone = new HomePhone(phoneNumber);
                UserPhoneValidation<String> hp = new UserPhoneValidation<String>(payment.getPhoneNumber());

                if (!hp.validateUserPhoneNumber(homePhone, phone -> homePhone.getPhoneNumber().matches("\\d+") && homePhone.getPhoneNumber().length() == 11)) {
                    System.out.println("Введенный номер не соответствует шаблону 89121115533");
                    throw new ServerValidationExeption();
                }
               System.out.println("Введите сумму для перевода");
               //TODO: 12.09.2020 добавить валидацию для введенной суммы
               amountToPay = scaner.nextLine();

            payment.setPhoneNumber(phoneNumber);
            payment.setAmountToPay(amountToPay);
            //добавить сюда обогащение обьекта или здесь возвращается обьект х и передаем его, потом в другом методе т.е. в одном месте создаем обьект пемент

            return payment;
       }
}


//собрала тел и сумму, вернула обьект 1
//
//получила тз други сточников валюту
//
//получила из другого источника еще что-то что нужно для обьекта платеж

// и тогда создала обьект платеж и его уже в метод передающий инфу на сервер

//добавить эксепшг
