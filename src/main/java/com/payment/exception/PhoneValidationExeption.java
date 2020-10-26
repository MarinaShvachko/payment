package com.payment.exception;

public class PhoneValidationExeption extends RuntimeException {

    public PhoneValidationExeption() {
    }

    public PhoneValidationExeption(String message) {
        super(message);
    }

    public PhoneValidationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneValidationExeption(Throwable cause) {
        super(cause);
    }

    public PhoneValidationExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
