package com.payment.common;

public enum Currency {
    RUB("643"),
    USD("840"),
    EUR("978");

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    Currency() {}

    public String getCurrency() {
        return currency;
    }
}
