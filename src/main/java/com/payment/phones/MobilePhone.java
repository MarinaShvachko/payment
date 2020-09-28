package com.payment.phones;

import lombok.Getter;

@Getter
public class MobilePhone extends Phone{
    private String mobilePhone;

    public  MobilePhone(String phone) {
        if (phone.length() == 11) {
            mobilePhone = phone;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
