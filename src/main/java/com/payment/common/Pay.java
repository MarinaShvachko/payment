package com.payment.common;

import com.payment.payment.PhoneAndAmountToPay;
import com.payment.payment.PaymentInfo;
import com.payment.server.Database;
import com.payment.user.User;

public interface Pay {
    PaymentInfo putTogetherPaymentInfoToSendToServer (User user, PhoneAndAmountToPay phoneAndAmountToPay, Currency currency, Database database);
}
