package com.payment.app;

import com.payment.common.Currency;
import com.payment.common.Pay;
import com.payment.payment.PhoneAndAmountToPay;
import com.payment.payment.PaymentInfo;
import com.payment.server.Database;
import com.payment.user.User;
import org.springframework.context.annotation.Configuration;


public class MobileApp implements Pay {

        //собрать вместе всю информацию: кто платит, кому(на какой номер), сколько, валюта
        @Override
        public PaymentInfo putTogetherPaymentInfoToSendToServer (User user, PhoneAndAmountToPay phoneAndAmountToPay, Currency currency, Database database) {
                PaymentInfo usersAndPaymentDetails = new PaymentInfo(user, phoneAndAmountToPay, currency);
                usersAndPaymentDetails.setDatabase(database);
                usersAndPaymentDetails.setAmountToPay(phoneAndAmountToPay.getAmountToPay());
                usersAndPaymentDetails.setPhoneNumber(phoneAndAmountToPay.getPhoneNumber());
                return  usersAndPaymentDetails;
        }

        public void checkOnDatabase(Database database, PhoneAndAmountToPay pnoneAndAmount) {
                database.putInDatabase(1, "89123334455");
                database.checkOnDatabase(database, pnoneAndAmount);
        }

        public MobileApp mobileApp() {
                return new MobileApp();
        }
}