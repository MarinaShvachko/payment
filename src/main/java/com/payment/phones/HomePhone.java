package com.payment.phones;


import lombok.Getter;

@Getter
public class HomePhone extends Phone {
 private String homePhone;

    public HomePhone(String phone) {
        if (phone.length() == 7) {
            homePhone = phone;
        } else {
            throw new IllegalArgumentException("Шаблон домашнего номера телефона не прошел проверку");
        }
    }
}
