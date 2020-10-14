package com.payment.phones;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MobilePhone extends Phone{
    private String mobilePhone;

    @Override
    public String getPhoneNumber() {
        return this.mobilePhone;
    }

}
