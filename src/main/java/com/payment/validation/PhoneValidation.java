package com.payment.validation;

import java.io.IOException;

//сделала класс дженериком для реализации домашнего задания к уроку 14
public class PhoneValidation<T> {
    private T val;

    public boolean validatePhoneLengthAndSimbols(String p) throws IOException {
        return (p.length() == 11 && p.matches("\\d+"))? true : false;
    }
}
