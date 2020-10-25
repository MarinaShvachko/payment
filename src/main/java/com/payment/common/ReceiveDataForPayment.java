package com.payment.common;

import com.payment.exception.PhoneValidationExeption;
import com.payment.payment.PhoneAndAmountToPay;
import com.payment.phones.HomePhone;
import com.payment.phones.Phone;
import com.payment.validation.UserPhoneValidator;
import java.util.Scanner;

public interface ReceiveDataForPayment {

    static PhoneAndAmountToPay ReceivePhoneNumberAndMoneyFromConsole() {
        Scanner scaner = new Scanner(System.in);
        String phoneNumber;
        String amountToPay;
        PhoneAndAmountToPay phoneAndAmountToPay = new PhoneAndAmountToPay();
        System.out.println("Введите номер телефона в формате 89121115533");

        phoneNumber = scaner.nextLine();
        Phone homePhone = new HomePhone(phoneNumber);
        UserPhoneValidator<String> hp = new UserPhoneValidator<>(phoneAndAmountToPay.getPhoneNumber());

        if (!hp.validateUserPhoneNumber(homePhone, phone -> homePhone.getPhoneNumber().matches("\\d+") && homePhone.getPhoneNumber().length() == 11)) {
            throw new PhoneValidationExeption("Введенный номер не соответствует шаблону 89123334455");
        }
        System.out.println("Введите сумму для перевода");
        //TODO: 12.09.2020 добавить валидацию для введенной суммы
        amountToPay = scaner.nextLine();

        phoneAndAmountToPay.setPhoneNumber(phoneNumber);
        phoneAndAmountToPay.setAmountToPay(amountToPay);

        return phoneAndAmountToPay;
    }
}