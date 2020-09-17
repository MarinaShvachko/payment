package com.payment.validation;

import java.math.BigDecimal;

public class AmountValidation {
    private boolean isPaymantPossible = false;

    public boolean isPaymantPossible(BigDecimal x, BigDecimal y) {
        if (x.compareTo(y) >= 0) {
            isPaymantPossible = true;
        }
        return isPaymantPossible;
    }
}
