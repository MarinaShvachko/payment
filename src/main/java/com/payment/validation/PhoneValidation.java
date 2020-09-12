package com.payment.validation;

//import com.payment.exception.PhoneValidationExeption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneValidation {
    boolean rightLengthPhoneNumber = false;

    public boolean validatePhoneLengthAndSimbols(String phoneNumber)throws IOException {
        if (phoneNumber.length() == 11) {
            if (phoneNumber.matches("\\d+"))  {
                rightLengthPhoneNumber = true;
            }
        }
        return rightLengthPhoneNumber;
    }
}