package com.payment.phones;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class HomePhone extends Phone {
    private String homePhone;

    @Override
    public String getPhoneNumber() {
        return this.homePhone;
    }
}
