package com.payment.validation;

import java.io.IOException;

public class PhoneValidation<T> {
    public boolean validatePhoneLengthAndSimbols(String p) throws IOException {
        return (p.length() == 11 && p.matches("\\d+"))? true : false;
    }
}

