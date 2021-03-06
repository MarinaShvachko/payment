package com.payment.common;

public enum Currency {
    RUB(643),
    USD(840),
    EUR(978);

    private int currency;

    Currency(int currency) {
        this.currency = currency;
    }

    Currency() {}

    public int getCurrency() {
        return currency;
    }
}
