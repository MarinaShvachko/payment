package com.payment.phones;


import lombok.Getter;

@Getter
public class HomePhone extends Phone {
 private String homePhone;

 public HomePhone(String phone) {
     this.homePhone = phone;
 }

 //@Override
//    public void Phone(String phone) {
//        if (phone.length() == 7) {
//            homePhone = phone;
//        } else {
//            throw new IllegalArgumentException("Шаблон домашнего номера телефона не прошел проверку");
//        }
//    }

    @Override
    public String getPhoneNumber() {
        return this.homePhone;
    }
}
