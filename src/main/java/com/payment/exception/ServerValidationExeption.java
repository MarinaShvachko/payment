package com.payment.exception;

public class ServerValidationExeption extends RuntimeException{
    public ServerValidationExeption() {
    }

    public ServerValidationExeption(String message) {
        super(message);
    }

    public ServerValidationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerValidationExeption(Throwable cause) {
        super(cause);
    }

    public ServerValidationExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
