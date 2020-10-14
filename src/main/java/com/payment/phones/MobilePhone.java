package com.payment.phones;

import lombok.Getter;

@Getter
public class MobilePhone extends Phone{
    private String mobilePhone;

    @Override
    public  void Phone(String phone) {
        if (phone.length() == 11) {
            mobilePhone = phone;
        } else {
            throw new IllegalArgumentException("Шаблон мобильного номера не прошел проверку");
        }
    }
}
