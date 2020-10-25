package com.payment.validation;

import java.math.BigDecimal;

public class AmountValidator {
    public boolean isPaymentPossible(BigDecimal x, BigDecimal y) {
        return x.compareTo(y) >= 0? true:false;
    }
}
