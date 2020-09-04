package com.payment;

import com.sun.xml.internal.bind.v2.TODO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;

public class App implements Pay, ReceiveDataForPayment {
        private BigDecimal paymentAmount;

        //узнать номер телефона и сумму, которую отправим по номеру телефона
        public ArrayList<Integer> ReceivePhoneNumber() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                Integer phoneNumber=0;
                Integer amountToPay=0;
                ArrayList<Integer> phoneAndAmount = new ArrayList<Integer>();
                System.out.println("Введите номер телефона");

                // TODO: 05.09.2020 разобраться почему стандартная длина телефона не принимается, а только 9 символов
                try {
                        phoneNumber = Integer.parseInt(reader.readLine()); 
                        System.out.println("Введите сумму для перевода");
                        amountToPay = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                        System.out.println("Для ввода допустимы только цифры");
                } catch (IOException e) {
                        //e.printStackTrace(); //здесь будет моя ошибка
                        System.out.println("Пожалуйста, перезагрузите приложение");
                }
                phoneAndAmount.add(phoneNumber);
                phoneAndAmount.add(amountToPay);
                return phoneAndAmount;
        }

        //оплатить
        public void pay() { //получает данные и передает их на сервер
        }
}
