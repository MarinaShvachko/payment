package com.payment.validation;

import com.payment.phones.Phone;
import lombok.Getter;

import java.util.function.Predicate;

@Getter
public class UserPhoneValidation<T> {
    private T phone;

    public UserPhoneValidation(T phone) {
        this.phone = phone;
    }

    public String toString() {
        return "" + phone + "";
    }

    public void validateUserPhoneNumber(Phone phone, Predicate<Phone> predicate) {
        boolean result = predicate.test(phone);
        //System.out.println(result);
    }
}