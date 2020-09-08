package com.payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

public class App implements Pay, ReceiveDataForPayment {
        private BigDecimal paymentAmount;

        //узнать номер телефона и сумму, которую отправим по номеру телефона
        public ArrayList<String> ReceivePhoneNumberAndMoney() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String phoneNumber = "";
                String amountToPay = "";
                ArrayList<String> phoneAndAmount = new ArrayList<String>();
                System.out.println("Введите номер телефона в формате 89121115533");

                        try {
                                phoneNumber = reader.readLine();
                                while (phoneNumber.length() < 11) {
                                        System.out.println("короткий, введите полный номер");
                                        phoneNumber = reader.readLine();
                                }
                                        System.out.println("Введите сумму для перевода");
                                        amountToPay = reader.readLine();

                        } catch (IOException e) {
                                System.out.println(e);
                        }

                        phoneAndAmount.add(phoneNumber);
                        phoneAndAmount.add(amountToPay);

                        return phoneAndAmount;
                }



        //оплатить: кто, сколько, кому
        public void pay() { //получает данные и передает их на сервер
        }
}
