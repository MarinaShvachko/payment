package com.payment.exception;

public class PaymentValidationExeption extends RuntimeException {
    public PaymentValidationExeption() {
    }

    public PaymentValidationExeption(String message) {
        super(message);
    }

    public PaymentValidationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentValidationExeption(Throwable cause) {
        super(cause);
    }

    public PaymentValidationExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
