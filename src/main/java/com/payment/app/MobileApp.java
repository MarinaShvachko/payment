package com.payment.app;

import com.payment.Pay;
import com.payment.ReceiveDataForPayment;
import com.payment.exception.PaymentValidationExeption;
import com.payment.server.Server;
import com.payment.user.User;
import com.payment.validation.AmountValidation;
import com.payment.validation.PhoneValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

//более гибко делать интерфейс, а для каждого типа приложения создавать класс, пример - телефонное приложение, десктопное приложение и т.п.

public class MobileApp implements Pay, ReceiveDataForPayment {
        //private BigDecimal paymentAmount;

        //узнать номер телефона и сумму, которую отправим по номеру телефона
        public ArrayList<String> ReceivePhoneNumberAndMoneyFromConsole() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String phoneNumber = "";
                String amountToPay = "";
                ArrayList<String> phoneAndAmount = new ArrayList<String>();
                System.out.println("Введите номер телефона в формате 89121115533");

                        try {
                                phoneNumber = reader.readLine();
                                PhoneValidation validate = new PhoneValidation();
                                while (!validate.validatePhoneLengthAndSimbols(phoneNumber)) {
                                        System.out.println("Введенный номер не соответствует шаблону 89121115533");
                                        phoneNumber = reader.readLine();
                                }
                                        System.out.println("Введите сумму для перевода");
                                //TODO: 12.09.2020 добавить валидацию для введенной суммы
                                        amountToPay = reader.readLine();
                        } catch (IOException e) {
                                System.out.println(e);
                        }
                        phoneAndAmount.add(phoneNumber);
                        phoneAndAmount.add(amountToPay);
                        return phoneAndAmount;
                }

        //оплатить: с какого счета, кому(на какой номер), сколько
        public ArrayList<String> payUsingPnonenumber(User user, ArrayList<String> pnoneAndAmount) {
                //имеющиеся деньги на счете
                BigDecimal currentAmountOfMoney = user.getAccountBalance();
                //сумма для списания со счета
                BigDecimal amountOfManeyToPay = new BigDecimal(pnoneAndAmount.get(1));

                //проверка хватит ли денег для оплаты
                AmountValidation amountValidation = new AmountValidation();
                if (amountValidation.isPaymantPossible(currentAmountOfMoney, amountOfManeyToPay) == true) {
                        //System.out.println("Оплата отправлена");

                } else {
                        throw new PaymentValidationExeption("Недостаточно денег на счете");
                }
                return pnoneAndAmount;

                // TODO: 12.09.2020 если денег хватило - добавить вычитание на счете
                //Server server = new Server("199.188.0.9.", 8080, "TCP");
//                System.out.println(user.getBankAccountNumber());
//                System.out.println(pnoneAndAmount.get(0));
//                System.out.println(pnoneAndAmount.get(1));
        }

}
