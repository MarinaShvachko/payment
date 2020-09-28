package com.payment.common;

import com.payment.payment.Payment;
import com.payment.user.User;

public interface Pay {
    Payment payUsingPhoneNumber(User user, Payment p, Currency currency);
}
