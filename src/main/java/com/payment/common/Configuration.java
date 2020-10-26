package com.payment.common;


import com.payment.app.MobileApp;
import com.payment.bankAccount.PersonBankAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class Configuration {

    @Bean
    public MobileApp getMobileApp() {
        return new MobileApp();
    }

    @Bean
    public PersonBankAccount getPersonBankAccount() {
        return new PersonBankAccount();
    }

}
