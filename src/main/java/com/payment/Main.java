package com.payment;

public class Main {
    public static void main(String[] args) {
        User vasia = new User("89124445566", "Вася", "Пупкин", 645544, 1, 654345);
        User masha = new User("89125555111", "Маша", "Орехова", 200, 2, 644477);

        System.out.println(vasia.getAccountBalance());
    }
}
